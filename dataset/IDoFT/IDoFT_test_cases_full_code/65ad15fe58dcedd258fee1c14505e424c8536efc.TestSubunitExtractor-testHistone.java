/** 
 * Make sure that only aminoacid chains are extracted: 5B2I.
 */
@Test public void testHistone() throws StructureException, IOException {
  Structure s=StructureIO.getStructure("5B2I");
  List<Subunit> subunits=SubunitExtractor.extractSubunits(s,5,0.75,20);
  assertEquals(subunits.size(),8);
  assertEquals(subunits.get(0).size(),99);
  assertEquals(subunits.get(1).size(),82);
  assertEquals(subunits.get(2).size(),106);
}
