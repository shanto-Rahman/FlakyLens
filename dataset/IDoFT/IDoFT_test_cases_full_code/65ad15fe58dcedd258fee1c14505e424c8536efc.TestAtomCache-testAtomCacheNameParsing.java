@Test public void testAtomCacheNameParsing() throws IOException, StructureException {
  String name1="4hhb";
  Structure s=cache.getStructure(name1);
  assertNotNull(s);
  assertEquals(4,s.getPolyChains().size());
  String name2="4hhb.C";
  String chainId2="C";
  s=cache.getStructure(name2);
  assertEquals(1,s.getPolyChains().size());
  assertEquals(3,s.getChains().size());
  Chain c=s.getPolyChainByPDB(chainId2);
  assertEquals(chainId2,c.getName());
  assertEquals(141,c.getAtomLength());
  assertEquals(141,s.getChainByIndex(0).getAtomLength());
  assertEquals(1,s.getChainByIndex(1).getAtomLength());
  assertEquals(59,s.getChainByIndex(2).getAtomLength());
  String name2b="4hhb:A";
  try {
    s=cache.getStructure(name2b);
    fail("Invalid structure format");
  }
 catch (  StructureException e) {
  }
  String name3="4hhb.1";
  String chainId3="B";
  s=cache.getStructure(name3);
  assertNotNull(s);
  assertEquals(1,s.getPolyChains().size());
  c=s.getPolyChainByPDB(chainId3);
  assertEquals(chainId3,c.getName());
  String name4="4hhb.A:10-20,B:10-20,C:10-20";
  s=cache.getStructure(name4);
  assertNotNull(s);
  assertEquals(3,s.getPolyChains().size());
  assertEquals(3,s.getChains().size());
  c=s.getPolyChainByPDB("B");
  assertEquals(11,c.getAtomLength());
  String name5="4hhb.(A:10-20,A:30-40)";
  s=cache.getStructure(name5);
  assertNotNull(s);
  assertEquals(1,s.getPolyChains().size());
  assertEquals(2,s.getChains().size());
  c=s.getPolyChainByPDB("A");
  assertEquals(22,c.getAtomLength());
  try {
    String name6="4hhb(A:10-20,A:30-40)";
    s=cache.getStructure(name6);
    fail("A chain separator is required after the ID since 4.2.0");
  }
 catch (  StructureException e) {
  }
  String name8="4hhb.(C)";
  s=cache.getStructure(name8);
  assertEquals(1,s.getPolyChains().size());
  c=s.getPolyChainByPDB(chainId2);
  assertEquals(chainId2,c.getName());
}
