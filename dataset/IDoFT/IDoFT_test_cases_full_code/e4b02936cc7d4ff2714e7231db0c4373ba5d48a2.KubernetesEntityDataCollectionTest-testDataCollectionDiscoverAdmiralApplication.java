@Test public void testDataCollectionDiscoverAdmiralApplication() throws Throwable {
  String testCompositeId="test-composite-id";
  List<BaseKubernetesState> testEntities=new ArrayList<>();
  testEntities.add(makeEntity("pod-1","my_prog_1",KubernetesUtil.POD_TYPE,testCompositeId));
  testEntities.add(makeEntity("pod-2","name-for-pod",KubernetesUtil.POD_TYPE,testCompositeId));
  testEntities.add(makeEntity("ser-1","my_service_1",KubernetesUtil.SERVICE_TYPE,testCompositeId));
  testEntities.add(makeEntity("depl-1","my_app_1",KubernetesUtil.DEPLOYMENT_TYPE,testCompositeId));
  testEntities.forEach(MockKubernetesAdapterService::addEntity);
  startDataCollectionAndWait();
  CompositeComponent compositeComponent=getDocument(CompositeComponent.class,"/resources/composite-components/" + testCompositeId);
  assertNotNull(compositeComponent);
  assertEquals(4,compositeComponent.componentLinks.size());
}
