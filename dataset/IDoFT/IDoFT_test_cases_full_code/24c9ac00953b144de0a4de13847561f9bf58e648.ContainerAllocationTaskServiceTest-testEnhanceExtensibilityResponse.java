@Test public void testEnhanceExtensibilityResponse() throws Throwable {
  createDockerHost(createDockerHostDescription(),resourcePool,true);
  containerDesc.customProperties=new HashMap<>();
  containerDesc.customProperties.put("customPropA","valueA");
  doOperation(containerDesc,UriUtils.buildUri(host,containerDesc.documentSelfLink),false,Action.PUT);
  ContainerAllocationTaskState allocationTask=createContainerAllocationTask();
  allocationTask.customProperties=new HashMap<>();
  allocationTask.customProperties.put("customPropB","valueB");
  allocationTask=allocate(allocationTask);
  final String selfLink=allocationTask.documentSelfLink;
  assertNotNull(selfLink);
  assertNotNull(allocationTask);
  assertEquals(1,allocationTask.resourceLinks.size());
  ContainerAllocationTaskService service=new ContainerAllocationTaskService();
  service.setHost(host);
  allocationTask.taskSubStage=null;
  AllocationExtensibilityCallbackResponse payload=(AllocationExtensibilityCallbackResponse)service.notificationPayload(allocationTask);
  List<HostSelection> beforeExtensibility=new ArrayList<>(allocationTask.hostSelections);
  payload.hosts=beforeExtensibility.stream().map(hs -> hs.name).collect(Collectors.toList());
  Collections.reverse(payload.hosts);
  assertNotEquals(beforeExtensibility,payload.hosts);
  TestContext context=new TestContext(1,Duration.ofMinutes(1));
  service.enhanceExtensibilityResponse(allocationTask,payload).whenComplete((r,err) -> {
    try {
      ContainerAllocationTaskState document=getDocument(ContainerAllocationTaskState.class,selfLink);
      assertNotNull(document);
      List<HostSelection> patchedHosts=new ArrayList<>(document.hostSelections);
      assertNotNull(patchedHosts);
      assertNotEquals(beforeExtensibility,patchedHosts);
      if (patchedHosts.size() == 4) {
        assertEquals(beforeExtensibility.get(1).name,patchedHosts.get(2).name);
        assertEquals(beforeExtensibility.get(0).name,patchedHosts.get(3).name);
      }
 else {
        context.failIteration(new Throwable("Expected 4 host selections."));
      }
    }
 catch (    Throwable throwable) {
      context.failIteration(throwable);
    }
    context.completeIteration();
  }
);
  context.await();
}
