/** 
 * Tests  {@link AtomCache#getStructureForDomain(String)} on a multi-chain domain with no ligands but an explicit range (not whole-chain).
 */
@Test public void testGetStructureForDomain1() throws IOException, StructureException {
assertEquals(2,structure.getPolyChains().size());
assertEquals(expectedLengthA,a.getAtomGroups().size());
assertEquals(expectedLengthB,b.getAtomGroups().size());
}