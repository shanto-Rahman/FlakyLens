@Test public void testFilterLocalHost() throws Exception {
assertNull(NetUtils.filterLocalHost(null));
assertEquals(NetUtils.filterLocalHost(""),"");
assertThat(host,equalTo("dubbo://" + NetUtils.getLocalHost() + ":8080/foo"));
assertThat(host,equalTo(NetUtils.getLocalHost() + ":8080"));
assertThat(host,equalTo(NetUtils.getLocalHost()));
assertThat(host,equalTo(host));
}