/** 
 * Test for #703 - Chemical component cache poisoning Handle empty CIF files
 * @throws IOException
 * @throws StructureException
 */
@Test public void testEmptyChemComp() throws IOException, StructureException {
logger.info("Testing AtomCache at //RW
assertTrue(Files.exists(chemCompCif));
assertEquals(0,Files.size(chemCompCif));
File src=new File(resource.getPath());//RO
assertTrue(Files.size(chemCompCif) > LocalPDBDirectory.MIN_PDB_FILE_SIZE);
assertNotNull(s);
assertTrue(g.getPDBName().equals("ATP"));
assertNotNull(chem);
assertTrue(chem.getAtoms().size() > 0);
assertEquals("NON-POLYMER",chem.getType());
}