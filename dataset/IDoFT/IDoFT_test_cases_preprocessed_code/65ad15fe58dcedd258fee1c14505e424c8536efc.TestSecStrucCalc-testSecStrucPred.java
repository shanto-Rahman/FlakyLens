@Test public void testSecStrucPred() throws StructureException, IOException {
assertEquals("SS assignment lengths do not match",biojava.size(),dssp.size() * structure.nrModels());
assertEquals("SS assignment position " + (i + 1) + " does not match",biojava.get(i),dssp.get(i));
}