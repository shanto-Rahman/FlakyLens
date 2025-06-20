@Test public void testGroupResourcePlacementAfterSuccessfulProvisionOperation() throws Throwable {
  ResourcePoolState resourcePool=createResourcePool();
  ContainerDescription containerDescription=createContainerDescription();
  GroupResourcePlacementState groupPlacementState=createGroupResourcePlacement(resourcePool);
  long allocatedInstancesCount=groupPlacementState.allocatedInstancesCount;
  RequestBrokerState request=new RequestBrokerState();
  request.resourceType=ResourceType.CONTAINER_TYPE.getName();
  request.resourceDescriptionLink=containerDescription.documentSelfLink;
  request.tenantLinks=groupPlacementState.tenantLinks;
  request=startRequest(request);
  request=waitForRequestToComplete(request);
  Set<String> resourceLinks=request.resourceLinks;
  groupPlacementState=getDocument(GroupResourcePlacementState.class,groupPlacementState.documentSelfLink);
  assertEquals("Allocated instances count was not increased after provisioning",groupPlacementState.allocatedInstancesCount,allocatedInstancesCount + 1);
  request=new RequestBrokerState();
  request.resourceType=ResourceType.CONTAINER_TYPE.getName();
  request.resourceDescriptionLink=containerDescription.documentSelfLink;
  request.resourceLinks=resourceLinks;
  request.tenantLinks=groupPlacementState.tenantLinks;
  request.operation=RequestBrokerState.REMOVE_RESOURCE_OPERATION;
  request=startRequest(request);
  waitForRequestToComplete(request);
  groupPlacementState=getDocument(GroupResourcePlacementState.class,groupPlacementState.documentSelfLink);
  assertEquals("Placement was not cleaned",groupPlacementState.allocatedInstancesCount,allocatedInstancesCount);
}
