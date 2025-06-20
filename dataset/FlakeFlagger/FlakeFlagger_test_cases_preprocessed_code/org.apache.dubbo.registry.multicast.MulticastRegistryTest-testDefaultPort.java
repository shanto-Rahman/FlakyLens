/** 
 * Test method for  {@link org.apache.dubbo.registry.multicast.MulticastRegistry#MulticastRegistry(URL)}
 */
@Test public void testDefaultPort(){
Assert.assertEquals(1234,multicastSocket.getLocalPort());
}