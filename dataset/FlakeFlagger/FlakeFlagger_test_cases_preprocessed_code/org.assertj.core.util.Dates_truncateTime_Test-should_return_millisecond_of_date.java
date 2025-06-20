@Test public void should_return_millisecond_of_date() throws ParseException {
assertEquals(expectedDate,truncateTime(date));
}