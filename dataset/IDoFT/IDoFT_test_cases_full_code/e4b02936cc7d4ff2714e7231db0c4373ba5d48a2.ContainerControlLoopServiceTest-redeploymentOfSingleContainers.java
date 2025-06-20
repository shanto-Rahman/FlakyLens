@SuppressWarnings("unchecked") @Test public void redeploymentOfSingleContainers() throws Throwable {
  containerDescription2=createContainerDescription(false);
  ServerSocket serverSocket=new ServerSocket();
  HealthConfig healthConfig=createHealthConfigTcp(serverSocket.getLocalPort());
  healthConfig.autoredeploy=true;
  containerDescription2.healthConfig=healthConfig;
  containerDescription2.tenantLinks=resourcePool.tenantLinks;
  doPut(containerDescription2);
  try {
    for (int i=0; i < SINGLE_CONTAINERS_TO_BE_PROVISIONED; i++) {
      ContainerState state=provisionContainer(containerDescription2.documentSelfLink);
      if (i < SINGLE_CONTAINERS_TO_BE_PROVISIONED - 1) {
        setContainerPowerState(state,PowerState.ERROR);
      }
    }
    Map<String,List<String>> containersPerContextId=new HashMap<>();
    retrieveContainerStates(containerDescription2.documentSelfLink).thenAccept(containerStates -> {
      containerStates.forEach(cs -> {
        containersPerContextId.put(cs.customProperties.get(RequestUtils.FIELD_NAME_CONTEXT_ID_KEY),Arrays.asList(cs.documentSelfLink));
      }
);
    }
);
    doOperation(new ContainerControlLoopState(),UriUtils.buildUri(host,ContainerControlLoopService.CONTROL_LOOP_INFO_LINK),false,Service.Action.PATCH);
    Map<String,List<String>> redeployedContainersPerContextId=new HashMap<>();
    AtomicBoolean containerFromDesc2Redeployed=new AtomicBoolean(false);
    waitFor(() -> {
      retrieveContainerStates(containerDescription2.documentSelfLink).thenAccept(containerStates -> {
        long healthyContainers=containerStates.stream().filter(cs -> PowerState.RUNNING == cs.powerState).count();
        host.log("Healthy containers from %s : %d",containerDescription2.documentSelfLink,healthyContainers);
        containerFromDesc2Redeployed.set(SINGLE_CONTAINERS_TO_BE_PROVISIONED == healthyContainers && SINGLE_CONTAINERS_TO_BE_PROVISIONED == containerStates.size());
        containerStates.forEach(cs -> {
          redeployedContainersPerContextId.put(cs.customProperties.get(RequestUtils.FIELD_NAME_CONTEXT_ID_KEY),Arrays.asList(cs.documentSelfLink));
        }
);
      }
);
      if (containerFromDesc2Redeployed.get()) {
        containersPerContextId.forEach((contextId,value) -> {
          List<String> redeployedContainers=redeployedContainersPerContextId.get(contextId);
          host.log("Redeployed container: %s -> %s",StringUtils.join(value),StringUtils.join(redeployedContainers));
        }
);
      }
      return containerFromDesc2Redeployed.get();
    }
);
  }
  finally {
    serverSocket.close();
  }
}
