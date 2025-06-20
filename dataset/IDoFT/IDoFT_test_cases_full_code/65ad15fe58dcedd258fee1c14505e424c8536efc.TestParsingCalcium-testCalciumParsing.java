@Test public void testCalciumParsing() throws StructureException, IOException {
  String pdbID="1SU4";
  AtomCache cache=new AtomCache();
  Structure s=cache.getStructure(pdbID);
  cache.setUseMmCif(true);
  Structure m=cache.getStructure(pdbID);
  Group g1=s.getNonPolyChainsByPDB("A").get(0).getGroupByPDB(new ResidueNumber("A",995,null));
  Group g2=m.getNonPolyChainsByPDB("A").get(0).getGroupByPDB(new ResidueNumber("A",995,null));
  assertEquals(g1.getAtom(0).getName(),"CA");
  assertEquals(g1.getAtom(0).getElement(),Element.Ca);
  assertEquals(g1.getAtom(0).getName(),g2.getAtom(0).getName());
}
