@Test public void testStructureWithBranchedEntities() throws IOException {
assertEquals(7,structure.getEntityInfos().size());
assertEquals(2,structure.getEntityById(1).getChains().size());
assertEquals(2,structure.getEntityById(2).getChains().size());
assertEquals(4,structure.getNonPolyChains().size());
assertEquals(4,structure.getPolyChains().size());
assertEquals(1,structure.getEntityById(3).getChains().size());
assertSame(structure.getNonPolyChain("E"),structure.getEntityById(3).getChains().get(0));
assertEquals(5,structure.getNonPolyChain("E").getAtomGroups().size());
}