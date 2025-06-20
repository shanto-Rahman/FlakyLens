@Test public void testSuffix() throws Exception {
assertNotNull(r);
assertEquals(1,r.size());
assertTrue(r.get(0) instanceof YAction);
}