@Test public void testShouldSelectHostFromAllResourcePools() throws Throwable {
  safeDelete(computeHost);
  computeHost=null;
  ResourcePoolState resourcePool=createResourcePool();
  ComputeDescription dockerHostDesc=createDockerHostDescription();
  ResourcePoolState defaultResourcePool=getDocument(ResourcePoolState.class,GroupResourcePlacementService.DEFAULT_RESOURCE_POOL_LINK);
  try {
    createDockerHost(dockerHostDesc,resourcePool);
    ContainerDescription containerDesc=createContainerDescription();
    GroupResourcePlacementState groupPlacementState=createGroupResourcePlacement(resourcePool);
    GroupResourcePlacementState groupPlacementState2=TestRequestStateFactory.createGroupResourcePlacementState();
    groupPlacementState2.memoryLimit=0;
    groupPlacementState2.resourcePoolLink=defaultResourcePool.documentSelfLink;
    groupPlacementState2=doPost(groupPlacementState2,GroupResourcePlacementService.FACTORY_LINK);
    RequestBrokerState request=TestRequestStateFactory.createRequestState();
    request.resourceDescriptionLink=containerDesc.documentSelfLink;
    request.tenantLinks=groupPlacementState.tenantLinks;
    host.log("########  Start of request ######## ");
    request=startRequest(request);
    waitForRequestToComplete(request);
  }
  finally {
    safeDelete(computeHost);
    computeHost=null;
  }
}
