@Test public void testRequestTrackerLinkShouldBeReturnedAndCreated() throws Throwable {
  ResourcePoolState resourcePool=createResourcePool();
  ComputeDescription dockerHostDesc=createDockerHostDescription();
  createDockerHost(dockerHostDesc,resourcePool);
  ContainerDescription containerDesc=createContainerDescription();
  GroupResourcePlacementState groupPlacementState=createGroupResourcePlacement(resourcePool);
  RequestBrokerState request=TestRequestStateFactory.createRequestState();
  request.resourceDescriptionLink=containerDesc.documentSelfLink;
  request.tenantLinks=groupPlacementState.tenantLinks;
  host.log("########  Start of request ######## ");
  request=startRequest(request);
  String requestTrackerLink=request.requestTrackerLink;
  assertNotNull("Request tracker link should not be null!",requestTrackerLink);
  assertFalse("Request tracker link should not be null!",requestTrackerLink.isEmpty());
  waitFor("request tracker stage was not updated",() -> {
    RequestStatus requestStatus=getDocument(RequestStatus.class,requestTrackerLink);
    assertNotNull(requestStatus);
    return requestStatus.taskInfo.stage.ordinal() > TaskStage.CREATED.ordinal();
  }
);
}
