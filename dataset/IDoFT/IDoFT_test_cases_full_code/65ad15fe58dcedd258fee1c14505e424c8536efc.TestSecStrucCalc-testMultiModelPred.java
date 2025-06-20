/** 
 * Test that calculating the secondary structure for multi-model systems works. Combine two PDBs into one multi-model system Calculate the secondary structure Combine with the combined list fetching from the server
 * @throws StructureException
 * @throws IOException
 */
@Test public void testMultiModelPred() throws StructureException, IOException {
  String pdbId="5pti";
  String pdbIdTwo="4hhb";
  SecStrucCalc sec=new SecStrucCalc();
  AtomCache cache=new AtomCache();
  Structure structure=cache.getStructure(pdbId);
  Structure structureTwo=cache.getStructure(pdbIdTwo);
  structure.addModel(structureTwo.getChains());
  List<SecStrucState> biojava=sec.calculate(structure,true);
  List<SecStrucState> dssp=DSSPParser.parseInputStream(new GZIPInputStream(this.getClass().getResourceAsStream("/org/biojava/nbio/structure/secstruc/" + pdbId + ".dssp.gz")),cache.getStructure(pdbId),false);
  dssp.addAll(DSSPParser.parseInputStream(new GZIPInputStream(this.getClass().getResourceAsStream("/org/biojava/nbio/structure/secstruc/" + pdbIdTwo + ".dssp.gz")),cache.getStructure(pdbIdTwo),false));
  assertEquals("SS assignment lengths do not match",biojava.size(),dssp.size());
  for (int i=0; i < dssp.size(); i++) {
    assertEquals("SS assignment position " + (i + 1) + " does not match",biojava.get(i),dssp.get(i));
  }
}
