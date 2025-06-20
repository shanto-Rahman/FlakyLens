/** 
 * Test method for    {@link org.apache.dubbo.registry.multicast.MulticastRegistry#MulticastRegistry(URL)} .
 */
@Test public void testGetCustomPort(){
assertThat(multicastRegistry.getUrl().getPort(),is(port));
}