@Test public void testContainerClusteringTaskAddContainersServiceRemove() throws Throwable {
  long containersNumberBeforeProvisioning=getExistingContainersInAdapter().size();
  assertEquals(0,containersNumberBeforeProvisioning);
  request=startRequest(request);
  RequestBrokerState initialState=waitForRequestToComplete(request);
  long containersNumberBeforeClustering=getExistingContainersInAdapter().size();
  assertEquals(3,containersNumberBeforeClustering);
  RequestBrokerState day2OperationClustering=TestRequestStateFactory.createRequestState();
  day2OperationClustering.resourceDescriptionLink=initialState.resourceDescriptionLink;
  day2OperationClustering.tenantLinks=groupPlacementState.tenantLinks;
  day2OperationClustering.operation=RequestBrokerState.CLUSTER_RESOURCE_OPERATION;
  day2OperationClustering.resourceCount=2;
  day2OperationClustering.documentDescription=containerDesc.documentDescription;
  day2OperationClustering.customProperties=initialState.customProperties;
  try {
    day2OperationClustering=startRequest(day2OperationClustering);
  }
 catch (  Throwable e) {
    throw new IllegalArgumentException(String.format("The following exception appears while trying to cluster containers: %s",e));
  }
  String containerClusteringTaskLink=UriUtils.buildUriPath(ClusteringTaskService.FACTORY_LINK,extractId(day2OperationClustering.documentSelfLink));
  waitForTaskSuccess(containerClusteringTaskLink,ClusteringTaskState.class);
  long containersNumberAfterClustering=getExistingContainersInAdapter().size();
  assertEquals(2,containersNumberAfterClustering);
  GroupResourcePlacementService.GroupResourcePlacementPoolState placementState=getDocument(GroupResourcePlacementService.GroupResourcePlacementPoolState.class,groupPlacementState.documentSelfLink);
  assertEquals(8,placementState.availableInstancesCount);
  assertEquals(2,placementState.allocatedInstancesCount);
}
