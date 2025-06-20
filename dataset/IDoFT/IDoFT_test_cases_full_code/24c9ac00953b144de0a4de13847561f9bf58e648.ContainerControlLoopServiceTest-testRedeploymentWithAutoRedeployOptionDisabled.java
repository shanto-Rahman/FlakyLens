@Test public void testRedeploymentWithAutoRedeployOptionDisabled() throws Throwable {
  final long timeoutInMillis=5000;
  ContainerDescription cd=createContainerDescription(false);
  ContainerState state=provisionContainer(cd.documentSelfLink);
  setContainerPowerState(state,PowerState.ERROR);
  doOperation(new ContainerControlLoopState(),UriUtils.buildUri(host,ContainerControlLoopService.CONTROL_LOOP_INFO_LINK),false,Service.Action.PATCH);
  state=getDocument(ContainerState.class,state.documentSelfLink);
  host.log("Power state = %s",state.powerState.name());
  long startTime=System.currentTimeMillis();
  final String link=state.documentSelfLink;
  AtomicBoolean healthyContainersFound=new AtomicBoolean(false);
  waitFor(() -> {
    ContainerState st=getDocument(ContainerState.class,link);
    host.log("Power state = %s",st.powerState.name());
    retrieveContainerStates(cd.documentSelfLink).thenAccept(containerStates -> {
      long healthyContainers=containerStates.stream().filter(cs -> PowerState.RUNNING == cs.powerState).count();
      host.log("healthyContainers = %d",healthyContainers);
      if (healthyContainers != 0) {
        healthyContainersFound.set(true);
      }
    }
);
    if (healthyContainersFound.get()) {
      fail("Should not have any healthy containers.");
    }
    return System.currentTimeMillis() - startTime > timeoutInMillis;
  }
);
}
