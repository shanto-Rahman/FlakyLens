public void testMoreComparisons() throws Exception {
assertTrue(c.compare(b,a) < 0);
assertTrue(c.compare(aa,bb) < 0);
assertTrue(c.compare(bbb,aaa) < 0);
assertTrue(c.compare(aaaa,bbb) < 0);
assertTrue(c.compare(x,y) < 0);
}