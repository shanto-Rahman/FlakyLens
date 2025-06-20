@Test public void testPrefixSuffixInteraction1() throws Exception {
assertNotNull(r);
assertEquals(1,r.size());
assertTrue(r.get(0) instanceof XAction);
assertEquals(3,xaction.id);
}