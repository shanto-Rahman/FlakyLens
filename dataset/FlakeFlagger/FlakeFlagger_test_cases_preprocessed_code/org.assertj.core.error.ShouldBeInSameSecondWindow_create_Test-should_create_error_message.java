@Test public void should_create_error_message() throws ParseException {
assertThat(message).isEqualTo("[Test] \nExpecting:\n  <2011-01-01T05:00:01>\nto be close to:\n  " + "<2011-01-01T05:00:02>\nby less than one second (strictly) but difference was: 1s" + " and 1ms");
}