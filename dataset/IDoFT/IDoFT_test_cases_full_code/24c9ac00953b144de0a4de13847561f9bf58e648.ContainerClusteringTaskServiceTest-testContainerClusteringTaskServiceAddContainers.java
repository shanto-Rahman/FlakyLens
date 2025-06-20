@Test public void testContainerClusteringTaskServiceAddContainers() throws Throwable {
  List<String> hostLinks=new ArrayList<>();
  hostLinks.add(createDockerHost(createDockerHostDescription(),createResourcePool(),(long)Integer.MAX_VALUE,true).documentSelfLink);
  hostLinks.add(createDockerHost(createDockerHostDescription(),createResourcePool(),(long)Integer.MAX_VALUE,true).documentSelfLink);
  hostLinks.add(createDockerHost(createDockerHostDescription(),createResourcePool(),(long)Integer.MAX_VALUE,true).documentSelfLink);
  hostLinks.add(createDockerHost(createDockerHostDescription(),createResourcePool(),(long)Integer.MAX_VALUE,true).documentSelfLink);
  long containersNumberBeforeProvisioning=getExistingContainersInAdapter().size();
  assertEquals(0,containersNumberBeforeProvisioning);
  request=startRequest(request);
  RequestBrokerState initialState=waitForRequestToComplete(request);
  Set<ContainerState> containersBeforeClustering=getExistingContainersInAdapter();
  Set<String> containersIdsBeforeClustering=containersBeforeClustering.stream().map(cs -> cs.id).collect(Collectors.toSet());
  long containersNumberBeforeClustering=containersBeforeClustering.size();
  assertEquals(3,containersNumberBeforeClustering);
  RequestBrokerState day2OperationClustering=TestRequestStateFactory.createRequestState();
  day2OperationClustering.resourceDescriptionLink=initialState.resourceDescriptionLink;
  day2OperationClustering.tenantLinks=groupPlacementState.tenantLinks;
  day2OperationClustering.operation=RequestBrokerState.CLUSTER_RESOURCE_OPERATION;
  day2OperationClustering.resourceCount=5;
  day2OperationClustering.documentDescription=containerDesc.documentDescription;
  day2OperationClustering.customProperties=initialState.customProperties;
  try {
    day2OperationClustering=startRequest(day2OperationClustering);
  }
 catch (  Throwable e) {
    throw new IllegalArgumentException(String.format("The following exception appears while trying to clustered containers: %s",e));
  }
  String containerClusteringTaskLink=UriUtils.buildUriPath(ClusteringTaskService.FACTORY_LINK,extractId(day2OperationClustering.documentSelfLink));
  waitForTaskSuccess(containerClusteringTaskLink,ClusteringTaskState.class);
  waitForRequestToComplete(day2OperationClustering);
  Set<ContainerState> containersAfterClustering=getExistingContainersInAdapter();
  long containersNumberAfterClustering=containersAfterClustering.size();
  assertEquals(5,containersNumberAfterClustering);
  Set<String> containersIdsAfterClustering=containersAfterClustering.stream().map(cs -> cs.id).collect(Collectors.toSet());
  assertTrue(containersIdsAfterClustering.containsAll(containersIdsBeforeClustering));
  GroupResourcePlacementService.GroupResourcePlacementPoolState placementState=getDocument(GroupResourcePlacementService.GroupResourcePlacementPoolState.class,groupPlacementState.documentSelfLink);
  assertEquals(5,placementState.availableInstancesCount);
  assertEquals(5,placementState.allocatedInstancesCount);
}
