@Test public void testWildcardFilterMiddleGlob() throws Exception {
assertTrue(filter.accepts(good));
assertTrue(filter.accepts(win));
assertFalse(filter.accepts(bad1));
assertFalse(filter.accepts(bad2));
assertFalse(filter.accepts(winbad));
}