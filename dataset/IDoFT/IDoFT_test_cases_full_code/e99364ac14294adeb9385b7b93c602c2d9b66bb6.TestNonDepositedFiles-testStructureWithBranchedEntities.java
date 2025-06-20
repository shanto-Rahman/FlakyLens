@Test public void testStructureWithBranchedEntities() throws IOException {
  URL url=new URL("https://raw.githubusercontent.com/pdbxmmcifwg/carbohydrate-extension/master/examples/models/1B5F-carb.cif");
  InputStream inStream=url.openStream();
  MMcifParser parser=new SimpleMMcifParser();
  SimpleMMcifConsumer consumer=new SimpleMMcifConsumer();
  parser.addMMcifConsumer(consumer);
  parser.parse(new BufferedReader(new InputStreamReader(inStream)));
  Structure structure=consumer.getStructure();
  assertEquals(7,structure.getEntityInfos().size());
  assertEquals(2,structure.getEntityById(1).getChains().size());
  assertEquals(2,structure.getEntityById(2).getChains().size());
  assertEquals(4,structure.getNonPolyChains().size());
  assertEquals(4,structure.getPolyChains().size());
  assertEquals(1,structure.getEntityById(3).getChains().size());
  assertSame(structure.getNonPolyChain("E"),structure.getEntityById(3).getChains().get(0));
  assertEquals(5,structure.getNonPolyChain("E").getAtomGroups().size());
}
