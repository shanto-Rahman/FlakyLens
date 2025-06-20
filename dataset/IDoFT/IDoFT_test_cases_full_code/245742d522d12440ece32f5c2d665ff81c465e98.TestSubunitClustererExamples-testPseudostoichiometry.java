/** 
 * Test pseudostoichiometry: 4HHB
 */
@Test public void testPseudostoichiometry() throws StructureException, IOException {
  Structure s=StructureIO.getStructure("4HHB");
  SubunitClustererParameters params=new SubunitClustererParameters();
  params.setClustererMethod(SubunitClustererMethod.SEQUENCE);
  params.setSequenceIdentityThreshold(0.95);
  List<SubunitCluster> clusters=SubunitClusterer.cluster(s,params).getClusters();
  assertEquals(clusters.size(),2);
  assertEquals(clusters.get(0).length(),141);
  assertEquals(clusters.get(1).length(),146);
  assertEquals(clusters.get(0).getClustererMethod(),SubunitClustererMethod.SEQUENCE);
  assertEquals(clusters.get(1).getClustererMethod(),SubunitClustererMethod.SEQUENCE);
  params.setClustererMethod(SubunitClustererMethod.SEQUENCE_STRUCTURE);
  params.setRMSDThreshold(3.0);
  clusters=SubunitClusterer.cluster(s,params).getClusters();
  assertEquals(clusters.size(),1);
  assertEquals(clusters.get(0).length(),140,2);
  assertEquals(clusters.get(0).getClustererMethod(),SubunitClustererMethod.STRUCTURE);
}
