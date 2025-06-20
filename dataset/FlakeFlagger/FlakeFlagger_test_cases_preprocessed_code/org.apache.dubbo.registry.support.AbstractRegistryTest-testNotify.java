/** 
 * Test method for   {@link org.apache.dubbo.registry.support.AbstractRegistry#notify(List)} .
 */
@Test public void testNotify() throws Exception {
Assert.assertThat(true,Matchers.equalTo(map.containsKey(url1)));
Assert.assertThat(false,Matchers.equalTo(map.containsKey(url2)));
Assert.assertThat(false,Matchers.equalTo(map.containsKey(url3)));
}