/** 
 * Test {@link SubunitCluster#mergeStructure(SubunitCluster,SubunitClustererParameters)}
 * @throws StructureException
 * @throws IOException
 */
@Test public void testMergeStructure() throws StructureException, IOException {
  Structure s=StructureIO.getStructure("4hhb");
  SubunitCluster sc1=new SubunitCluster(new Subunit(StructureTools.getRepresentativeAtomArray(s.getChainByIndex(0)),"chain 0",null,s));
  SubunitCluster sc2=new SubunitCluster(new Subunit(StructureTools.getRepresentativeAtomArray(s.getChainByIndex(1)),"chain 1",null,s));
  SubunitCluster sc3=new SubunitCluster(new Subunit(StructureTools.getRepresentativeAtomArray(s.getChainByIndex(2)),"chain 2",null,s));
  SubunitCluster sc4=new SubunitCluster(new Subunit(StructureTools.getRepresentativeAtomArray(s.getChainByIndex(3)),"chain 3",null,s));
  SubunitClustererParameters clustererParameters=new SubunitClustererParameters();
  clustererParameters.setRMSDThreshold(3.0);
  clustererParameters.setStructureCoverageThreshold(0.9);
  boolean merged13=sc1.mergeStructure(sc3,clustererParameters);
  boolean merged24=sc2.mergeStructure(sc4,clustererParameters);
  assertTrue(merged13);
  assertTrue(merged24);
  assertEquals(2,sc1.size());
  assertEquals(2,sc2.size());
  assertEquals(141,sc1.length());
  assertEquals(146,sc2.length());
  assertEquals(sc1.getAlignedAtomsSubunit(0).length,sc1.getAlignedAtomsSubunit(1).length);
  assertEquals(sc2.getAlignedAtomsSubunit(0).length,sc2.getAlignedAtomsSubunit(1).length);
  boolean merged=sc1.mergeStructure(sc2,clustererParameters);
  assertTrue(merged);
  assertEquals(4,sc1.size());
  assertEquals(140,sc1.length(),2);
  assertEquals(sc1.getAlignedAtomsSubunit(0).length,sc1.getAlignedAtomsSubunit(2).length);
}
