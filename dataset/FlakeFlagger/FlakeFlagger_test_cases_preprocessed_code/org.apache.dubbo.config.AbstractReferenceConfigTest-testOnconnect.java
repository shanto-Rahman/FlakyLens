@Test public void testOnconnect() throws Exception {
assertThat(referenceConfig.getOnconnect(),equalTo("onConnect"));
assertThat(referenceConfig.getStubevent(),is(true));
}