@Test public void testGroupResourcePlacementAfterFailedProvisionOperation() throws Throwable {
  ResourcePoolState resourcePool=createResourcePool();
  ContainerDescription containerDescription=createContainerDescription();
  GroupResourcePlacementState groupPlacementState=createGroupResourcePlacement(resourcePool);
  long allocatedInstancesCount=groupPlacementState.allocatedInstancesCount;
  RequestBrokerState request=new RequestBrokerState();
  request.resourceType=ResourceType.CONTAINER_TYPE.getName();
  request.resourceDescriptionLink=containerDescription.documentSelfLink;
  request.tenantLinks=groupPlacementState.tenantLinks;
  request=startRequest(request);
  waitForRequestToComplete(request);
  groupPlacementState=getDocument(GroupResourcePlacementState.class,groupPlacementState.documentSelfLink);
  assertEquals("Allocated instances count is not correct",groupPlacementState.allocatedInstancesCount,allocatedInstancesCount + 1);
  MockDockerAdapterService service=new MockDockerAdapterService();
  service.setSelfLink(MockDockerAdapterService.SELF_LINK);
  host.stopService(service);
  request=new RequestBrokerState();
  request.resourceType=ResourceType.CONTAINER_TYPE.getName();
  request.resourceDescriptionLink=containerDescription.documentSelfLink;
  request.tenantLinks=groupPlacementState.tenantLinks;
  request=startRequest(request);
  waitForRequestToFail(request);
  groupPlacementState=getDocument(GroupResourcePlacementState.class,groupPlacementState.documentSelfLink);
  assertEquals("Allocated instances count is not correct after a failed provisioning",groupPlacementState.allocatedInstancesCount,allocatedInstancesCount + 1);
}
