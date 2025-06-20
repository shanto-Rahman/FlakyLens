/** 
 * Test parsing of chain-less ranges (present in SCOP < 1.73)
 * @throws IOException
 * @throws StructureException
 */
@Test public void testGetStructureForChainlessDomains() throws IOException, StructureException {
  ScopDatabase scop=ScopFactory.getSCOP(ScopFactory.VERSION_1_71);
  Structure structure=cache.getStructureForDomain("d1hcy_1",scop);
  assertEquals(1,structure.getPolyChains().size());
  Chain a=structure.getPolyChainByPDB("A");
  int expectedLengthA=135;
  assertEquals(expectedLengthA,a.getAtomGroups().size());
  assertTrue(structure.hasNonPolyChain("G"));
  assertTrue(structure.hasNonPolyChain("H"));
  Chain copper=structure.getNonPolyChain("I");
  assertEquals(1,copper.getAtomGroups().size());
}
