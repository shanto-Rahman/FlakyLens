/** 
 * Test method for  {@link org.apache.dubbo.registry.multicast.MulticastRegistry#getRegistered()}.
 */
@Test public void testRegister(){
assertTrue(registered.contains(serviceUrl));
assertEquals(1,registered.size());
}