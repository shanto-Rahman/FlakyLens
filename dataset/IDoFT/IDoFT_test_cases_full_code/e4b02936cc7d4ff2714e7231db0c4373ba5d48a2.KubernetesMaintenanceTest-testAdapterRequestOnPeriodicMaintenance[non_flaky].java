@Test public void testAdapterRequestOnPeriodicMaintenance() throws Throwable {
  PodState podState=new PodState();
  podState.pod=new Pod();
  podState.pod.spec=new PodSpec();
  podState.pod.spec.containers=new ArrayList<>();
  Container container1=new Container();
  container1.name="container1";
  container1.image="test-image";
  podState.pod.spec.containers.add(container1);
  podState.pod.metadata=new ObjectMeta();
  podState.pod.metadata.selfLink="/api/v1/namespaces/default/pods/test-pod";
  podState.pod.metadata.name="test-pod";
  podState=doPost(podState,PodFactoryService.SELF_LINK);
  waitFor(() -> MockKubernetesAdapterService.requestOnInspect != null);
  assertNotNull(MockKubernetesAdapterService.requestOnInspect);
  assertEquals(KubernetesOperationType.INSPECT.id,MockKubernetesAdapterService.requestOnInspect.operationTypeId);
  assertEquals(podState.documentSelfLink,MockKubernetesAdapterService.requestOnInspect.resourceReference.getPath());
  MockKubernetesAdapterService.requestOnInspect=null;
}
