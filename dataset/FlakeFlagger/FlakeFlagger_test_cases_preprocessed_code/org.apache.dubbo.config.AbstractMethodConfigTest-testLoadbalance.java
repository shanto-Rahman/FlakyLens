@Test public void testLoadbalance() throws Exception {
assertThat(methodConfig.getLoadbalance(),equalTo("mockloadbalance"));
}