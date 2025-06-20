@Test public void testConstructor2() throws Exception {
assertThat(status.getLevel(),is(OK));
assertThat(status.getMessage(),equalTo("message"));
assertThat(status.getDescription(),isEmptyOrNullString());
}