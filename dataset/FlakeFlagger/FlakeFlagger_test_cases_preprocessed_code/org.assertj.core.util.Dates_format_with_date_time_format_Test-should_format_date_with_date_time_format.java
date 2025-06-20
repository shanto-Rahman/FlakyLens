@Test public void should_format_date_with_date_time_format() throws ParseException {
assertEquals("1994-08-26T00:00:00",formatAsDatetime(formatter.parse(dateAsString)));
}