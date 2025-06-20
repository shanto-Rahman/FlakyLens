/** 
 * Test that calculating the secondary structure for multi-model systems works. Combine two PDBs into one multi-model system Calculate the secondary structure Combine with the combined list fetching from the server
 * @throws StructureException
 * @throws IOException
 */
@Test public void testMultiModelPred() throws StructureException, IOException {
assertEquals("SS assignment lengths do not match",biojava.size(),dssp.size());
assertEquals("SS assignment position " + (i + 1) + " does not match",biojava.get(i),dssp.get(i));
}