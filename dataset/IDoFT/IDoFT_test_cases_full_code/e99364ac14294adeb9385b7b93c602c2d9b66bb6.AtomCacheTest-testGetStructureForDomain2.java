/** 
 * Tests  {@link AtomCache#getStructureForDomain(String)} on a multi-chain domain with two zinc ligands that occurs after the TER. The ligands are in chains E and F, so they should not be included in the domain.
 */
@Test public void testGetStructureForDomain2() throws IOException, StructureException {
  String ranges="A:,B:";
  Structure whole=cache.getStructure("1I3O");
  AtomPositionMap map=new AtomPositionMap(StructureTools.getAllAtomArray(whole),AtomPositionMap.ANYTHING_MATCHER);
  List<ResidueRangeAndLength> rrs=ResidueRangeAndLength.parseMultiple(ranges,map);
  int expectedLengthA=rrs.get(0).getLength();
  int expectedLengthB=rrs.get(1).getLength();
  Structure structure=cache.getStructureForDomain("d1i3o.1");
  assertEquals(2,structure.getPolyChains().size());
  Chain a=structure.getPolyChainByPDB("A");
  Chain b=structure.getPolyChainByPDB("B");
  assertEquals(expectedLengthA - 3,a.getAtomGroups().size());
  assertEquals(expectedLengthB - 4,b.getAtomGroups().size());
  List<Group> ligandsA=StructureTools.filterLigands(b.getAtomGroups());
  assertEquals(0,ligandsA.size());
  List<Group> ligandsB=StructureTools.filterLigands(b.getAtomGroups());
  assertEquals(0,ligandsB.size());
}
