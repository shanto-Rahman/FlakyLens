@Test public void testOndisconnect() throws Exception {
assertThat(referenceConfig.getOndisconnect(),equalTo("onDisconnect"));
assertThat(referenceConfig.getStubevent(),is(true));
}