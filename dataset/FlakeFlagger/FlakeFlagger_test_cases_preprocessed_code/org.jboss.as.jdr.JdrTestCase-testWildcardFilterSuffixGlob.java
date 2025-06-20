@Test public void testWildcardFilterSuffixGlob() throws Exception {
assertTrue(filter.accepts(good));
assertFalse(filter.accepts(bad));
assertTrue(filter.accepts(wingood));
assertFalse(filter.accepts(winbad));
}