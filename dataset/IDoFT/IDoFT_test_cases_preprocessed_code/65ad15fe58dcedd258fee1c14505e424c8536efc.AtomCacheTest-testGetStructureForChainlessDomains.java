/** 
 * Test parsing of chain-less ranges (present in SCOP < 1.73)
 * @throws IOException
 * @throws StructureException
 */
@Test public void testGetStructureForChainlessDomains() throws IOException, StructureException {
assertEquals(1,structure.getPolyChains().size());
assertEquals(expectedLengthA,a.getAtomGroups().size());
assertTrue(structure.hasNonPolyChain("G"));
assertTrue(structure.hasNonPolyChain("H"));
assertEquals(1,copper.getAtomGroups().size());
}