/** 
 * Make sure that only aminoacid chains are extracted: 5B2I.
 */
@Test public void testHistone() throws StructureException, IOException {
assertEquals(subunits.size(),8);
assertEquals(subunits.get(0).size(),99);
assertEquals(subunits.get(1).size(),82);
assertEquals(subunits.get(2).size(),106);
}