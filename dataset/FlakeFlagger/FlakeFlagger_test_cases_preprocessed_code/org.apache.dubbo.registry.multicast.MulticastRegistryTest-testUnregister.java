/** 
 * Test method for  {@link org.apache.dubbo.registry.multicast.MulticastRegistry#unregister(URL)}.
 */
@Test public void testUnregister(){
assertTrue(registered.contains(serviceUrl));
assertFalse(registered.contains(serviceUrl));
}