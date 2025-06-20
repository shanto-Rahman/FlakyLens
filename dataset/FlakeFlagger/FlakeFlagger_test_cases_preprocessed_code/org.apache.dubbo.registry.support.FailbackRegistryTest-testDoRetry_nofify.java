@Test public void testDoRetry_nofify() throws Exception {
count.incrementAndGet();
if (count.get() == 1l) {
}
registry=new MockRegistry(registryUrl,new CountDownLatch(0));//RW
registry.subscribe(serviceUrl.setProtocol(Constants.CONSUMER_PROTOCOL).addParameters(CollectionUtils.toStringMap("check","false")),listner);//RW
assertEquals(1,count.get());
if (count.get() == 2) break;
Thread.sleep(sleeptime);
assertEquals(2,count.get());
}