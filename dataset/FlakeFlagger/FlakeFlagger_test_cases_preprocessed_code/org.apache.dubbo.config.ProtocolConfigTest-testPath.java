@Test public void testPath() throws Exception {
assertThat(protocol.getPath(),equalTo("context-path"));
assertThat(protocol.getContextpath(),equalTo("context-path"));
assertThat(parameters.isEmpty(),is(true));
assertThat(protocol.getPath(),equalTo("path"));
assertThat(protocol.getContextpath(),equalTo("path"));
}