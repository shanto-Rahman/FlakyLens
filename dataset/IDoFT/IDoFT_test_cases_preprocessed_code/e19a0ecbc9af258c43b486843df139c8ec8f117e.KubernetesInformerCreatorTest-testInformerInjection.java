@Test public void testInformerInjection() throws InterruptedException {
assertNotNull(podInformer);
assertNotNull(configMapInformer);
assertNotNull(podLister);
assertNotNull(configMapLister);
Thread.sleep(200);
assertEquals(1,podLister.list().size());
assertEquals(1,configMapLister.list().size());
}