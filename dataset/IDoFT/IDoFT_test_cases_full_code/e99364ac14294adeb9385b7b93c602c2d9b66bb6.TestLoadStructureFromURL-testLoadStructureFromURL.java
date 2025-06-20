@Test public void testLoadStructureFromURL() throws IOException, StructureException {
  String path=new UserConfiguration().getCacheFilePath();
  File f=new File(path,"TEST DIR");
  f.deleteOnExit();
  if (!f.exists()) {
    System.out.println("making dir with space:" + f);
    f.mkdir();
  }
  AtomCache c=new AtomCache(f.toString(),f.toString());
  c.setUseMmCif(false);
  c.setUseMmtf(false);
  c.getStructure("1znf");
  File subdir=f;
  for (  String dir : PDBFileReader.PDB_SPLIT_DIR) {
    subdir=new File(subdir,dir);
    subdir.deleteOnExit();
  }
  subdir=new File(subdir,"zn");
  File newFile=new File(subdir,"pdb1znf.ent.gz");
  subdir.deleteOnExit();
  newFile.deleteOnExit();
  URL u=newFile.toURI().toURL();
  Structure s=c.getStructure(u.toString() + "?args=test");
  assertNotNull(s);
}
