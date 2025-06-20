@Test public void testRetries() throws Exception {
assertThat(methodConfig.getRetries(),equalTo(3));
}