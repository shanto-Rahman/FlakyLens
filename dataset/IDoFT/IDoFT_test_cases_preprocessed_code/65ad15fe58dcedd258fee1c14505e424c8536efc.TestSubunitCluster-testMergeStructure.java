/** 
 * Test {@link SubunitCluster#mergeStructure(SubunitCluster,SubunitClustererParameters)}
 * @throws StructureException
 * @throws IOException
 */
@Test public void testMergeStructure() throws StructureException, IOException {
assertTrue(merged13);
assertTrue(merged24);
assertEquals(2,sc1.size());
assertEquals(2,sc2.size());
assertEquals(141,sc1.length());
assertEquals(146,sc2.length());
assertEquals(sc1.getAlignedAtomsSubunit(0).length,sc1.getAlignedAtomsSubunit(1).length);
assertEquals(sc2.getAlignedAtomsSubunit(0).length,sc2.getAlignedAtomsSubunit(1).length);
assertTrue(merged);
assertEquals(4,sc1.size());
assertEquals(140,sc1.length(),2);
assertEquals(sc1.getAlignedAtomsSubunit(0).length,sc1.getAlignedAtomsSubunit(2).length);
}