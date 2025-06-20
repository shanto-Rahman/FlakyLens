/** 
 * Test method for    {@link org.apache.dubbo.registry.multicast.MulticastRegistry#MulticastRegistry(URL)}
 */
@Test public void testCustomedPort(){
assertEquals(port,multicastSocket.getLocalPort());
}