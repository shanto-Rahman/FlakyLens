@Test public void testDoRetry_subscribe() throws Exception {
registry=new MockRegistry(registryUrl,latch);//RW
registry.setBad(true);//IT
registry.register(serviceUrl);//RW
registry.setBad(false);//IT
if (latch.getCount() == 0) break;
Thread.sleep(sleeptime);
assertEquals(0,latch.getCount());
}