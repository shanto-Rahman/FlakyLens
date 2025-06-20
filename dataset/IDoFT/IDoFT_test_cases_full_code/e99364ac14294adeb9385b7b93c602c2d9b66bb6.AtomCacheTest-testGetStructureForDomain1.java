/** 
 * Tests  {@link AtomCache#getStructureForDomain(String)} on a multi-chain domain with no ligands but an explicit range (not whole-chain).
 */
@Test public void testGetStructureForDomain1() throws IOException, StructureException {
  String ranges="A:328-396,B:518-527";
  Structure whole=cache.getStructure("1h6w");
  AtomPositionMap map=new AtomPositionMap(StructureTools.getAllAtomArray(whole),AtomPositionMap.ANYTHING_MATCHER);
  List<ResidueRangeAndLength> rrs=ResidueRangeAndLength.parseMultiple(ranges,map);
  int expectedLengthA=rrs.get(0).getLength();
  int expectedLengthB=rrs.get(1).getLength();
  Structure structure=cache.getStructureForDomain("d1h6w.2");
  assertEquals(2,structure.getPolyChains().size());
  Chain a=structure.getPolyChainByPDB("A");
  Chain b=structure.getPolyChainByPDB("B");
  assertEquals(expectedLengthA,a.getAtomGroups().size());
  assertEquals(expectedLengthB,b.getAtomGroups().size());
}
