@Test public void testMatchesCommaSeparatedArray() throws IOException {
assertEquals(MatchStatus.FOUND,matcher.matches(getProperties("foo: bar,spam")));
}