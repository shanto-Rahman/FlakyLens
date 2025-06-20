@Test public void testEqualsAndHashCodeSpanningSegments() throws Exception {
assertTrue(a.equals(b));
assertTrue(a.hashCode() == b.hashCode());
assertFalse(a.equals(c));
assertFalse(a.hashCode() == c.hashCode());
}