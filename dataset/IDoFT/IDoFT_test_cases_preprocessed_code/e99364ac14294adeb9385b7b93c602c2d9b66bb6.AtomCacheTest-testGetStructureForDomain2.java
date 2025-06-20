/** 
 * Tests  {@link AtomCache#getStructureForDomain(String)} on a multi-chain domain with two zinc ligands that occurs after the TER. The ligands are in chains E and F, so they should not be included in the domain.
 */
@Test public void testGetStructureForDomain2() throws IOException, StructureException {
assertEquals(2,structure.getPolyChains().size());
assertEquals(expectedLengthA - 3,a.getAtomGroups().size());
assertEquals(expectedLengthB - 4,b.getAtomGroups().size());
assertEquals(0,ligandsA.size());
assertEquals(0,ligandsB.size());
}