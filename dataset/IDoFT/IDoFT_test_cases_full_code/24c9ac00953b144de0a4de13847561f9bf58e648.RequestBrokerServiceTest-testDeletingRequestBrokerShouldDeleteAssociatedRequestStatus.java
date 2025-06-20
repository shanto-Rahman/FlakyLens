@Test public void testDeletingRequestBrokerShouldDeleteAssociatedRequestStatus() throws Throwable {
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
  request=waitForRequestToComplete(request);
  String requestTrackerLink=request.requestTrackerLink;
  RequestStatus requestStatus=searchForDocument(RequestStatus.class,requestTrackerLink);
  assertNotNull(requestStatus);
  delete(request.documentSelfLink);
  waitFor("RequestStatus wasn't deleted: " + requestStatus.documentSelfLink,() -> {
    RequestStatus reqStatus=searchForDocument(RequestStatus.class,requestTrackerLink);
    return reqStatus == null;
  }
);
}
