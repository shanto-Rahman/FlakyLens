@Test public void testd1gena(){
  try {
    URL u=new URL("http://scop.berkeley.edu/astral/pdbstyle/ver=2.03&id=d1gena_&output=txt.");
    PDBFileParser p=new PDBFileParser();
    Structure s=p.parsePDBFile(u.openStream());
    Assert.assertTrue(StructureTools.getAllAtomArray(s).length > 100);
  }
 catch (  Exception e) {
    e.printStackTrace();
    Assert.fail(e.getMessage());
  }
}
