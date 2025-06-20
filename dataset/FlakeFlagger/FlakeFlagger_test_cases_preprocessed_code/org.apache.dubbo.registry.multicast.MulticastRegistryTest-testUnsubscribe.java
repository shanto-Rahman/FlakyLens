/** 
 * Test method for  {@link org.apache.dubbo.registry.multicast.MulticastRegistry#unsubscribe(URL,NotifyListener)}
 */
@Test public void testUnsubscribe(){
assertTrue(listeners.isEmpty());
assertTrue(received.get(consumerUrl).isEmpty());
}