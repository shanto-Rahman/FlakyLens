@Test public void testMatchesSingleValue() throws IOException {
assertEquals(MatchStatus.FOUND,matcher.matches(getProperties("foo: bar")));
}