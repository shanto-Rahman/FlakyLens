@Test public void should_create_error_message_ignoring_seconds() throws ParseException {
assertThat(message).isEqualTo("[Test] \nExpecting:\n  <2011-01-01T05:00:00>\n" + "to have same year, month, day, hour and minute as:\n  " + "<2011-01-01T06:05:17>\n"+ "but had not.");
}