@Test public void testConstructor1() throws Exception {
assertThat(status.getLevel(),is(OK));
assertThat(status.getMessage(),equalTo("message"));
assertThat(status.getDescription(),equalTo("description"));
}