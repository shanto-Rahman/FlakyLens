@Test public void testClusteredContainerAllocationWithFollowingProvisioningRequestWithHeathCheckIncludedShoudFail() throws Throwable {
  host.log(">>>>>>Start: testClusteredContainerAllocationWithFollowingProvisioningRequestWithHeathCheckIncludedShoudFail <<<<< ");
  final int clusterSize=5;
  containerDesc.healthConfig=createHealthConfigTcp(2);
  containerDesc.healthConfig.ignoreOnProvision=false;
  containerDesc._cluster=clusterSize;
  doOperation(containerDesc,UriUtils.buildUri(host,containerDesc.documentSelfLink),false,Action.PUT);
  ContainerAllocationTaskState allocationTask=createContainerAllocationTask(containerDesc.documentSelfLink,clusterSize);
  allocationTask.customProperties=new HashMap<>();
  allocationTask.customProperties.put(RequestUtils.FIELD_NAME_ALLOCATION_REQUEST,Boolean.TRUE.toString());
  allocationTask=allocate(allocationTask);
  assertContainerStateAfterAllocation(allocationTask);
  configureHealthCheckTimeout(DEFAULT_HEALTH_CHECK_TIMEOUT);
  configureHealthCheckDelay(DEFAULT_HEALTH_CHECK_DELAY);
  RequestBrokerState provisioningRequest=new RequestBrokerState();
  provisioningRequest.resourceType=allocationTask.resourceType;
  provisioningRequest.resourceLinks=allocationTask.resourceLinks;
  provisioningRequest.resourceCount=clusterSize;
  provisioningRequest.resourceDescriptionLink=containerDesc.documentSelfLink;
  provisioningRequest.operation=ContainerOperationType.CREATE.id;
  provisioningRequest=doPost(provisioningRequest,RequestBrokerFactoryService.SELF_LINK);
  assertNotNull(provisioningRequest);
  waitForRequestToFail(provisioningRequest);
}
