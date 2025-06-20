@Test public void testRequestLifeCycleFailureShouldCleanReservations() throws Throwable {
  ResourcePoolState resourcePool=createResourcePool();
  ComputeDescription dockerHostDesc=createDockerHostDescription();
  createDockerHost(dockerHostDesc,resourcePool);
  ContainerDescription containerDesc=createContainerDescription();
  GroupResourcePlacementState groupPlacementState=createGroupResourcePlacement(resourcePool);
  assertEquals(0,groupPlacementState.allocatedInstancesCount);
  RequestBrokerState request=TestRequestStateFactory.createRequestState();
  request.resourceDescriptionLink=containerDesc.documentSelfLink;
  request.tenantLinks=groupPlacementState.tenantLinks;
  request.customProperties=new HashMap<>();
  request.customProperties.put(MockDockerAdapterService.FAILURE_EXPECTED,Boolean.TRUE.toString());
  request=startRequest(request);
  waitForRequestToFail(request);
  groupPlacementState=getDocument(GroupResourcePlacementState.class,groupPlacementState.documentSelfLink);
  assertEquals(0,groupPlacementState.allocatedInstancesCount);
}
