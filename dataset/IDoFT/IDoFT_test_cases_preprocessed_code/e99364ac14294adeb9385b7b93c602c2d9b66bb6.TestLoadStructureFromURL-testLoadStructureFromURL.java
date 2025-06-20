@Test public void testLoadStructureFromURL() throws IOException, StructureException {
File f=new File(path,"TEST DIR");
if (!f.exists()) {
}
subdir=new File(subdir,dir);
subdir=new File(subdir,"zn");
File newFile=new File(subdir,"pdb1znf.ent.gz");
assertNotNull(s);
}