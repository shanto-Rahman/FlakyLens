@Test public void testChemComps() throws IOException, StructureException {
Assert.assertEquals(3,s.getPolyChains().size());
Assert.assertEquals("H",c2.getName());
if (ch.getName().equals("H")) {
}
if (pdbName.equals("QWE")) darPresent=true;
 else if (pdbName.equals("H2O")) noWater=false;
if (pdbName.equals("H2O")) noWater=false;
Assert.assertTrue("Found water in ligands list!",noWater);
Assert.assertTrue("Did not find QWE in ligands list!",darPresent);
Assert.assertEquals("Did not find the correct nr of ligands in chain! ",3,hChainLigandGroups.size());
}