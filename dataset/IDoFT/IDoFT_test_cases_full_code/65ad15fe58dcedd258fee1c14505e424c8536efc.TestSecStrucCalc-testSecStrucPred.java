@Test public void testSecStrucPred() throws StructureException, IOException {
  List<String> names=Arrays.asList("5pti","1tim","4hhb","1how","4i4q","2k4t","1deu");
  SecStrucCalc sec=new SecStrucCalc();
  for (  String name : names) {
    AtomCache cache=new AtomCache();
    Structure structure=cache.getStructure(name);
    List<SecStrucState> biojava=sec.calculate(structure,true);
    List<SecStrucState> dssp=DSSPParser.parseInputStream(new GZIPInputStream(this.getClass().getResourceAsStream("/org/biojava/nbio/structure/secstruc/" + name + ".dssp.gz")),structure,false);
    assertEquals("SS assignment lengths do not match",biojava.size(),dssp.size() * structure.nrModels());
    for (int i=0; i < dssp.size(); i++) {
      assertEquals("SS assignment position " + (i + 1) + " does not match",biojava.get(i),dssp.get(i));
    }
  }
}
