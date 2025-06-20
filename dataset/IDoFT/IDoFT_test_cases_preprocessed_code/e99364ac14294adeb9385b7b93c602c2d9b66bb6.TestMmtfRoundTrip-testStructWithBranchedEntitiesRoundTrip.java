@Test public void testStructWithBranchedEntitiesRoundTrip() throws IOException {
assertEquals(7,structure2.getEntityInfos().size());
assertEquals(2,structure2.getEntityById(1).getChains().size());
assertEquals(2,structure2.getEntityById(2).getChains().size());
assertEquals(4,structure2.getNonPolyChains().size());
assertEquals(4,structure2.getPolyChains().size());
assertEquals(1,structure2.getEntityById(3).getChains().size());
assertSame(structure2.getNonPolyChain("E"),structure2.getEntityById(3).getChains().get(0));
assertEquals(5,structure2.getNonPolyChain("E").getAtomGroups().size());
}