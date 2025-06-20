/** 
 * Test method for   {@link org.apache.dubbo.registry.support.AbstractRegistry#unregister(URL)} .
 * @throws Exception
 */
@Test public void testUnregister() throws Exception {
Assert.assertThat(false,Matchers.equalTo(abstractRegistry.getRegistered().contains(url)));
Assert.assertThat(0,Matchers.equalTo(abstractRegistry.getRegistered().size()));
}