/** 
 * Tests  {@link AtomCache#getStructureForDomain(String)} on a single-chain domain with two zinc ligands that occurs after the TER.
 */
@Test public void testGetStructureForDomain3() throws IOException, StructureException {
assertEquals(1,structure.getPolyChains().size());
assertEquals(expectedLengthE - 2,e.getAtomGroups().size());
assertEquals(1,ligandsE.size());
}