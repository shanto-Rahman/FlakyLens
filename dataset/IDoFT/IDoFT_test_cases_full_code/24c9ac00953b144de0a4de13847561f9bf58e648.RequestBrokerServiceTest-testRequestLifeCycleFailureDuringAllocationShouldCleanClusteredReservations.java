@Test public void testRequestLifeCycleFailureDuringAllocationShouldCleanClusteredReservations() throws Throwable {
  ResourcePoolState resourcePool=createResourcePool();
  ComputeDescription dockerHostDesc=createDockerHostDescription();
  createDockerHost(dockerHostDesc,resourcePool);
  ContainerDescription desc=TestRequestStateFactory.createContainerDescription();
  desc.documentSelfLink=UUID.randomUUID().toString();
  desc._cluster=5;
  ContainerDescription containerDesc=doPost(desc,ContainerDescriptionService.FACTORY_LINK);
  GroupResourcePlacementState groupPlacementState=createGroupResourcePlacement(resourcePool);
  assertEquals(0,groupPlacementState.allocatedInstancesCount);
  RequestBrokerState request=TestRequestStateFactory.createRequestState();
  request.resourceDescriptionLink=containerDesc.documentSelfLink;
  request.tenantLinks=groupPlacementState.tenantLinks;
  request.customProperties=new HashMap<>();
  request.customProperties.put(FIELD_NAME_ALLOCATION_REQUEST,Boolean.TRUE.toString());
  DeploymentProfileConfig.getInstance().failOnStage(ContainerAllocationTaskState.SubStage.CONTEXT_PREPARED);
  try {
    request=startRequest(request);
    waitForRequestToFail(request);
  }
  finally {
    DeploymentProfileConfig.getInstance().failOnStage(null);
  }
  groupPlacementState=getDocument(GroupResourcePlacementState.class,groupPlacementState.documentSelfLink);
  assertEquals(0,groupPlacementState.allocatedInstancesCount);
}
