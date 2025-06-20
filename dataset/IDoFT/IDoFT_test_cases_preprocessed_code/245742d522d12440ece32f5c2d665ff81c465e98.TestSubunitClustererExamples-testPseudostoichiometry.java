/** 
 * Test pseudostoichiometry: 4HHB
 */
@Test public void testPseudostoichiometry() throws StructureException, IOException {
assertEquals(clusters.size(),2);
assertEquals(clusters.get(0).length(),141);
assertEquals(clusters.get(1).length(),146);
assertEquals(clusters.get(0).getClustererMethod(),SubunitClustererMethod.SEQUENCE);
assertEquals(clusters.get(1).getClustererMethod(),SubunitClustererMethod.SEQUENCE);
assertEquals(clusters.size(),1);
assertEquals(clusters.get(0).length(),140,2);
assertEquals(clusters.get(0).getClustererMethod(),SubunitClustererMethod.STRUCTURE);
}