@Test public void testRequestLifeCycleWithContainerNetworkAndClusterAntiAffinityFilterShouldPass() throws Throwable {
  host.log("########  Start of testRequestLifeCycleWithContainerNetworkAndClusterAntiAffinityFilterShouldPass ######## ");
  ResourcePoolState resourcePool=createResourcePool();
  ComputeDescription dockerHostDesc=createDockerHostDescription();
  delete(computeHost.documentSelfLink);
  computeHost=null;
  dockerHostDesc.customProperties.put(ContainerHostService.DOCKER_HOST_CLUSTER_STORE_PROP_NAME,"my-kv-store-1");
  ComputeState dockerHost1=createDockerHost(dockerHostDesc,resourcePool,true);
  addForDeletion(dockerHost1);
  ComputeState dockerHost2=createDockerHost(dockerHostDesc,resourcePool,true);
  addForDeletion(dockerHost2);
  List<String> cluster1Hosts=Arrays.asList(dockerHost1.documentSelfLink,dockerHost2.documentSelfLink);
  dockerHostDesc.customProperties.put(ContainerHostService.DOCKER_HOST_CLUSTER_STORE_PROP_NAME,"my-kv-store-2");
  ComputeState dockerHost3=createDockerHost(dockerHostDesc,resourcePool,true);
  addForDeletion(dockerHost3);
  ComputeState dockerHost4=createDockerHost(dockerHostDesc,resourcePool,true);
  addForDeletion(dockerHost4);
  List<String> cluster2Hosts=Arrays.asList(dockerHost3.documentSelfLink,dockerHost4.documentSelfLink);
  String networkName="MyNet";
  ContainerNetworkDescription networkDesc=TestRequestStateFactory.createContainerNetworkDescription(networkName);
  networkDesc.documentSelfLink=UUID.randomUUID().toString();
  ContainerDescription container1Desc=TestRequestStateFactory.createContainerDescription();
  container1Desc.documentSelfLink=UUID.randomUUID().toString();
  container1Desc.name="Container1";
  container1Desc.networks=new HashMap<>();
  container1Desc.networks.put(networkName,new ServiceNetwork());
  ContainerDescription container2Desc=TestRequestStateFactory.createContainerDescription();
  container2Desc.documentSelfLink=UUID.randomUUID().toString();
  container2Desc.name="Container2";
  container2Desc.networks=new HashMap<>();
  container2Desc.networks.put(networkName,new ServiceNetwork());
  CompositeDescription compositeDesc=createCompositeDesc(networkDesc,container1Desc,container2Desc);
  assertNotNull(compositeDesc);
  GroupResourcePlacementState groupPlacementState=createGroupResourcePlacement(resourcePool);
  RequestBrokerState request=TestRequestStateFactory.createRequestState(ResourceType.COMPOSITE_COMPONENT_TYPE.getName(),compositeDesc.documentSelfLink);
  request.tenantLinks=groupPlacementState.tenantLinks;
  host.log("########  Start of request ######## ");
  request=startRequest(request);
  request=waitForRequestToComplete(request);
  assertEquals(1,request.resourceLinks.size());
  CompositeComponent cc=getDocument(CompositeComponent.class,request.resourceLinks.iterator().next());
  String networkLink=null;
  String containerLink1=null;
  String containerLink2=null;
  Iterator<String> iterator=cc.componentLinks.iterator();
  while (iterator.hasNext()) {
    String link=iterator.next();
    if (link.startsWith(ContainerNetworkService.FACTORY_LINK)) {
      networkLink=link;
    }
 else     if (containerLink1 == null) {
      containerLink1=link;
    }
 else {
      containerLink2=link;
    }
  }
  ContainerState cont1=getDocument(ContainerState.class,containerLink1);
  ContainerState cont2=getDocument(ContainerState.class,containerLink2);
  List<String> selectedCluster=null;
  if (cluster1Hosts.contains(cont1.parentLink)) {
    selectedCluster=cluster1Hosts;
  }
 else   if (cluster2Hosts.contains(cont1.parentLink)) {
    selectedCluster=cluster2Hosts;
  }
  assertNotNull(selectedCluster);
  boolean containersAreProvisionedOnTheSameCluster=selectedCluster.contains(cont2.parentLink);
  assertTrue(containersAreProvisionedOnTheSameCluster);
  ContainerNetworkState network=getDocument(ContainerNetworkState.class,networkLink);
  boolean networkProvisionedOnTheSameCluster=selectedCluster.contains(network.originatingHostLink);
  assertTrue(networkProvisionedOnTheSameCluster);
  assertEquals(cc.documentSelfLink,cont1.compositeComponentLink);
  assertEquals(cc.documentSelfLink,cont2.compositeComponentLink);
  assertTrue((network.compositeComponentLinks.size() == 1) && network.compositeComponentLinks.contains(cc.documentSelfLink));
  dockerHostDesc.customProperties.put(ContainerHostService.DOCKER_HOST_CLUSTER_STORE_PROP_NAME,"my-kv-store-3");
  addForDeletion(createDockerHost(dockerHostDesc,resourcePool,true));
  addForDeletion(createDockerHost(dockerHostDesc,resourcePool,true));
  addForDeletion(createDockerHost(dockerHostDesc,resourcePool,true));
  addForDeletion(createDockerHost(dockerHostDesc,resourcePool,true));
  int SCALE_SIZE=8;
  RequestBrokerState day2OperationClustering=TestRequestStateFactory.createRequestState();
  day2OperationClustering.resourceDescriptionLink=cont1.descriptionLink;
  day2OperationClustering.tenantLinks=groupPlacementState.tenantLinks;
  day2OperationClustering.operation=RequestBrokerState.CLUSTER_RESOURCE_OPERATION;
  day2OperationClustering.resourceCount=1 + SCALE_SIZE;
  day2OperationClustering.documentDescription=containerDesc.documentDescription;
  day2OperationClustering.customProperties=cont1.customProperties;
  day2OperationClustering.addCustomProperty(FIELD_NAME_CONTEXT_ID_KEY,Service.getId(cc.documentSelfLink));
  host.log("########  Start of request ######## ");
  request=startRequest(day2OperationClustering);
  request=waitForRequestToComplete(request);
  assertEquals(SCALE_SIZE,request.resourceLinks.size());
  for (  String scaledContainerLink : request.resourceLinks) {
    ContainerState scaledContainer=getDocument(ContainerState.class,scaledContainerLink);
    boolean scaledContainersAreProvisionedOnTheSameCluster=selectedCluster.contains(scaledContainer.parentLink);
    assertTrue(scaledContainersAreProvisionedOnTheSameCluster);
  }
  cc=getDocument(CompositeComponent.class,cc.documentSelfLink);
  assertEquals(SCALE_SIZE + 3,cc.componentLinks.size());
}
