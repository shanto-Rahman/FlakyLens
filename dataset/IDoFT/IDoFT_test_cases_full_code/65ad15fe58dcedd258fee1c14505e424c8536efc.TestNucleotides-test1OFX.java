@Test public void test1OFX() throws StructureException, IOException {
  Structure s=getStructure("1OFX");
  assertEquals(2,s.getPolyChains().size());
  Chain a=s.getChains().get(0);
  assertEquals("A",a.getId());
  List<Group> ngrA=a.getAtomGroups(GroupType.NUCLEOTIDE);
  assertEquals(10,ngrA.size());
  Chain b=s.getChains().get(1);
  assertEquals("B",b.getId());
  List<Group> ngrB=b.getAtomGroups(GroupType.NUCLEOTIDE);
  assertEquals(10,ngrB.size());
}
