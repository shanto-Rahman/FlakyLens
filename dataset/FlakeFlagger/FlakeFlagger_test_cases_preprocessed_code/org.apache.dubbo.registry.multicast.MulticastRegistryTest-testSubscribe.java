/** 
 * Test method for {@link org.apache.dubbo.registry.multicast.MulticastRegistry#subscribe(URL url, org.apache.dubbo.registry.NotifyListener)}.
 */
@Test public void testSubscribe(){
assertEquals(serviceUrl.toFullString(),urls.get(0).toFullString());
assertEquals(consumerUrl,subscribed.keySet().iterator().next());
}