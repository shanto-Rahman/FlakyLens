@Test public void testAtomCacheNameParsing() throws IOException, StructureException {
assertNotNull(s);
assertEquals(4,s.getPolyChains().size());
assertEquals(1,s.getPolyChains().size());
assertEquals(3,s.getChains().size());
assertEquals(chainId2,c.getName());
assertEquals(141,c.getAtomLength());
assertEquals(141,s.getChainByIndex(0).getAtomLength());
assertEquals(1,s.getChainByIndex(1).getAtomLength());
assertEquals(59,s.getChainByIndex(2).getAtomLength());
fail("Invalid structure format");
assertNotNull(s);
assertEquals(1,s.getPolyChains().size());
assertEquals(chainId3,c.getName());
assertNotNull(s);
assertEquals(3,s.getPolyChains().size());
assertEquals(3,s.getChains().size());
assertEquals(11,c.getAtomLength());
assertNotNull(s);
assertEquals(1,s.getPolyChains().size());
assertEquals(2,s.getChains().size());
assertEquals(22,c.getAtomLength());
fail("A chain separator is required after the ID since 4.2.0");
assertEquals(1,s.getPolyChains().size());
assertEquals(chainId2,c.getName());
}