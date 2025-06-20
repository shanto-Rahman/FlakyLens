@Test public void testConstructor3() throws Exception {
assertThat(status.getLevel(),is(OK));
assertThat(status.getMessage(),isEmptyOrNullString());
assertThat(status.getDescription(),isEmptyOrNullString());
}