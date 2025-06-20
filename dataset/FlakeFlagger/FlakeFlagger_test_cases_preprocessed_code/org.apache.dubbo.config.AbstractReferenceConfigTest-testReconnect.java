@Test public void testReconnect() throws Exception {
assertThat(referenceConfig.getReconnect(),equalTo("reconnect"));
assertThat(parameters,hasKey(Constants.RECONNECT_KEY));
}