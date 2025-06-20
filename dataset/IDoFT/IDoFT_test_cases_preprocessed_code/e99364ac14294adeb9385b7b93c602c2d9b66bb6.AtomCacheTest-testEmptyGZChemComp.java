/** 
 * Test for #703 - Chemical component cache poisoning Handle empty CIF files
 * @throws IOException
 * @throws StructureException
 */
@Test public void testEmptyGZChemComp() throws IOException, StructureException {
logger.info("Testing AtomCache at //RW
try (GZIPOutputStream out=new GZIPOutputStream(new FileOutputStream(sub.toFile())))
assertTrue(Files.exists(sub));
assertTrue(0 < Files.size(sub) && Files.size(sub) < LocalPDBDirectory.MIN_PDB_FILE_SIZE);
File src=new File(resource.getPath());//RO
assertTrue(Files.size(sub) > LocalPDBDirectory.MIN_PDB_FILE_SIZE);
assertNotNull(s);
assertTrue(g.getPDBName().equals("ATP"));
assertNotNull(chem);
assertTrue(chem.getAtoms().size() > 0);
assertEquals("NON-POLYMER",chem.getType());
}