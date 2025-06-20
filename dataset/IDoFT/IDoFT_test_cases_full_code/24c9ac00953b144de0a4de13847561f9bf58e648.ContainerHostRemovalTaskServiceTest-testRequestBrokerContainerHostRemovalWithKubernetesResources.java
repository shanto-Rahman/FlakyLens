@Test public void testRequestBrokerContainerHostRemovalWithKubernetesResources() throws Throwable {
  computeHost.customProperties.put(ContainerHostService.CONTAINER_HOST_TYPE_PROP_NAME,ContainerHostType.KUBERNETES.name());
  computeHost=doPatch(computeHost,computeHost.documentSelfLink);
  PodState podState=new PodState();
  podState.parentLink=computeHost.documentSelfLink;
  podState=doPost(podState,PodFactoryService.SELF_LINK);
  ServiceState serviceState=new ServiceState();
  serviceState.parentLink=computeHost.documentSelfLink;
  serviceState=doPost(serviceState,ServiceEntityFactoryHandler.SELF_LINK);
  RequestBrokerState request=new RequestBrokerState();
  request.resourceType=ResourceType.CONTAINER_HOST_TYPE.getName();
  request.resourceLinks=new HashSet<>(Collections.singletonList(computeHost.documentSelfLink));
  request.operation=RequestBrokerState.REMOVE_RESOURCE_OPERATION;
  request=startRequest(request);
  waitForRequestToComplete(request);
  List<String> podStateLinks=findResourceLinks(PodState.class,Collections.singletonList(podState.documentSelfLink));
  assertTrue("PodState links not removed: " + podStateLinks,podStateLinks.isEmpty());
  List<String> serviceStateLinks=findResourceLinks(ServiceState.class,Collections.singletonList(serviceState.documentSelfLink));
  assertTrue("ServiceState links not removed: " + serviceStateLinks,serviceStateLinks.isEmpty());
  Collection<String> computeSelfLinks=findResourceLinks(ComputeState.class,Collections.singletonList(computeHost.documentSelfLink));
  assertTrue("ComputeState was not deleted: " + computeSelfLinks,computeSelfLinks.isEmpty());
}
