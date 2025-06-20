/** 
 * test notifyList
 */
@Test public void testNotifyList() throws Exception {
Assert.assertThat(true,Matchers.equalTo(map.containsKey(url1)));
Assert.assertThat(true,Matchers.equalTo(map.containsKey(url2)));
Assert.assertThat(true,Matchers.equalTo(map.containsKey(url3)));
}