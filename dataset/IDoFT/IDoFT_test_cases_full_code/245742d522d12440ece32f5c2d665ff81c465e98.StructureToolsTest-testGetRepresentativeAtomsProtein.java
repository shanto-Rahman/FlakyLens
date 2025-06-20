@Test public void testGetRepresentativeAtomsProtein() throws StructureException, IOException {
  Structure s=StructureIO.getStructure("1smt");
  Chain c=s.getChainByIndex(0);
  Atom[] atoms=StructureTools.getRepresentativeAtomArray(c);
  assertEquals(98,atoms.length);
  Chain clonedChain=(Chain)c.clone();
  atoms=StructureTools.getRepresentativeAtomArray(clonedChain);
  assertEquals(98,atoms.length);
}
