@Test public void testDoRetry_register() throws Exception {
notified.set(Boolean.TRUE);
registry=new MockRegistry(registryUrl,latch);//RW
registry.setBad(true);//IT
registry.subscribe(serviceUrl.setProtocol(Constants.CONSUMER_PROTOCOL).addParameters(CollectionUtils.toStringMap("check","false")),listner);//RW
assertEquals(false,notified.get());
assertEquals(1,latch.getCount());
registry.setBad(false);//IT
if (latch.getCount() == 0) break;
Thread.sleep(sleeptime);
assertEquals(0,latch.getCount());
assertEquals(true,notified.get());
}