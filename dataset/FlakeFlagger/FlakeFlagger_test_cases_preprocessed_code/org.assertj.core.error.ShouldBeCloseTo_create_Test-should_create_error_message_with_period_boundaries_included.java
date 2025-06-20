@Test public void should_create_error_message_with_period_boundaries_included() throws ParseException {
assertEquals("[Test] \nExpecting:\n <2011-01-01T00:00:00.000>\nto be close to:\n <2011-01-01T00:00:00.101>\nby less than 100ms but difference was 101ms",message);
}