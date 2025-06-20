/** 
 * Test method for   {@link org.apache.dubbo.registry.support.FailbackRegistry#retry()} .
 * @throws Exception
 */
@Test public void testDoRetry() throws Exception {
notified.set(Boolean.TRUE);
registry=new MockRegistry(registryUrl,latch);//RW
registry.setBad(true);//IT
registry.register(serviceUrl);//RW
registry.unregister(serviceUrl);//RW
registry.subscribe(serviceUrl.setProtocol(Constants.CONSUMER_PROTOCOL).addParameters(CollectionUtils.toStringMap("check","false")),listner);//RW
registry.unsubscribe(serviceUrl.setProtocol(Constants.CONSUMER_PROTOCOL).addParameters(CollectionUtils.toStringMap("check","false")),listner);//RW
assertEquals(false,notified.get());
assertEquals(3,latch.getCount());
registry.setBad(false);//IT
if (latch.getCount() == 0) break;
Thread.sleep(sleeptime);
assertEquals(0,latch.getCount());
assertEquals(false,notified.get());
}