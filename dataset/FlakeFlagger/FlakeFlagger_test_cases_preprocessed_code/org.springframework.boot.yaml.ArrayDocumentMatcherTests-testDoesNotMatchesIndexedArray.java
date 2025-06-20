@Test public void testDoesNotMatchesIndexedArray() throws IOException {
assertEquals(MatchStatus.ABSTAIN,matcher.matches(getProperties("foo[0]: bar\nfoo[1]: spam")));
}