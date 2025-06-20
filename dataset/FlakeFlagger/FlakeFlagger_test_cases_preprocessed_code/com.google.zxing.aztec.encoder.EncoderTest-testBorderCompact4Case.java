@Test public void testBorderCompact4Case() throws Exception {
fail("Encode should have failed.  Text can't fit in 1-layer compact");
assertFalse(aztecCode.isCompact());
assertEquals(4,aztecCode.getLayers());
assertTrue(aztecCode.isCompact());
assertEquals(4,aztecCode.getLayers());
}