@Test public void testChains() throws IOException, StructureException {
  String pdbId="1qdm";
  AtomPositionMap map=new AtomPositionMap(cache.getAtoms(pdbId));
  ResidueNumber start, end;
  try {
    start=new ResidueNumber("A",6,'P');
    end=new ResidueNumber("B",338,null);
    map.getLength(start,end);
    fail("Chain missmatch");
  }
 catch (  IllegalArgumentException e) {
  }
  try {
    start=new ResidueNumber("A",6,'P');
    end=new ResidueNumber("B",338,null);
    map.getLengthDirectional(start,end);
    fail("Chain missmatch");
  }
 catch (  IllegalArgumentException e) {
  }
  start=new ResidueNumber("A",338,null);
  end=new ResidueNumber("B",6,'P');
  int len=map.getLength(map.getPosition(start),map.getPosition(end),"A");
  assertEquals(1,len);
}
