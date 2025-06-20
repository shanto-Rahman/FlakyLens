@Test public void testUserSpecifiedLayers() throws Exception {
assertEquals(2,aztec.getLayers());
assertTrue(aztec.isCompact());
assertEquals(32,aztec.getLayers());
assertFalse(aztec.isCompact());
fail("Encode should have failed.  No such thing as 33 layers");
fail("Encode should have failed.  Text can't fit in 1-layer compact");
}