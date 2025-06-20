@Test public void should_create_error_message_ignoring_hours() throws ParseException {
assertThat(message).isEqualTo("[Test] \nExpecting:\n  <2011-01-01T05:00:00>\n" + "to have same year, month and day as:\n  " + "<2011-01-01T06:05:17>\n"+ "but had not.");
}