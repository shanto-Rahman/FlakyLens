@Test public void testEqualsAndHashCode() throws Exception {
assertFalse(a.equals(b));
assertFalse(a.hashCode() == b.hashCode());
assertTrue(a.equals(b));
assertTrue(a.hashCode() == b.hashCode());
}