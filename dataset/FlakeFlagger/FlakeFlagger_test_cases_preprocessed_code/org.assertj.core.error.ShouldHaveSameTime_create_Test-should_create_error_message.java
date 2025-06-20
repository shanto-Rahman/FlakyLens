@Test public void should_create_error_message() throws ParseException {
assertThat(message).isEqualTo("[Test] \n" + "Expecting\n" + "  <2011-01-01T05:01:00>\n"+ "to have the same time as:\n"+ "  <2011-01-01T05:01:01>\n"+ "but actual time is\n"+ "  <" + actual.getTime() + "L>\n"+ "and expected was:\n"+ "  <"+ expected.getTime()+ "L>");
}