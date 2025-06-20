@Test public void testChemComps() throws IOException, StructureException {
  AtomCache cache=new AtomCache();
  FileParsingParameters params=cache.getFileParsingParams();
  params.setAlignSeqRes(true);
  Structure s=cache.getStructure("1a4w");
  Assert.assertEquals(3,s.getPolyChains().size());
  Chain c2=s.getChainByIndex(1);
  Assert.assertEquals("H",c2.getName());
  List<Group> hChainLigandGroups=new ArrayList<>();
  for (  Chain ch : s.getNonPolyChains()) {
    if (ch.getName().equals("H")) {
      hChainLigandGroups.addAll(ch.getAtomGroups());
    }
  }
  boolean noWater=true;
  boolean darPresent=false;
  for (  Group g : hChainLigandGroups) {
    String pdbName=g.getPDBName();
    if (pdbName.equals("QWE"))     darPresent=true;
 else     if (pdbName.equals("H2O"))     noWater=false;
  }
  Assert.assertTrue("Found water in ligands list!",noWater);
  Assert.assertTrue("Did not find QWE in ligands list!",darPresent);
  Assert.assertEquals("Did not find the correct nr of ligands in chain! ",3,hChainLigandGroups.size());
}
