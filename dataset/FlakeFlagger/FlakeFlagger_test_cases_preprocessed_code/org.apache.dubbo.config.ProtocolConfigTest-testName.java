@Test public void testName() throws Exception {
assertThat(protocol.getName(),equalTo("name"));
assertThat(protocol.getId(),equalTo("name"));
assertThat(parameters.isEmpty(),is(true));
}