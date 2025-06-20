@Test public void should_create_error_message() throws ParseException {
assertThat(message).isEqualTo("[Test] \nExpecting:\n  <2011-01-01T05:00:00>\nto be close to:\n  " + "<2011-01-01T06:05:17>\n" + "by less than one hour (strictly) but difference was: 1h 5m 17s and 3ms");
}