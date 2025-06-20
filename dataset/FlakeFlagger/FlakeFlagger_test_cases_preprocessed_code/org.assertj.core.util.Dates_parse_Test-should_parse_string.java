@Test public void should_parse_string() throws ParseException {
assertEquals(formatter.parse(dateAsString),parse("1994-08-26"));
}