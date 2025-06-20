@Test public void testMMcifURL() throws StructureException, IOException {
  String u="http://ftp.wwpdb.org/pub/pdb/data/biounit/mmCIF/divided/nw/4nwr-assembly1.cif.gz";
  Structure s=StructureIO.getStructure(u);
  assertNotNull(s);
}
