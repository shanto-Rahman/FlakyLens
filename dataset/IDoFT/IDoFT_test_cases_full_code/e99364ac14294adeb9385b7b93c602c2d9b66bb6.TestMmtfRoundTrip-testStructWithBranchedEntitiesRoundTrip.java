@Test public void testStructWithBranchedEntitiesRoundTrip() throws IOException {
  URL url=new URL("https://raw.githubusercontent.com/pdbxmmcifwg/carbohydrate-extension/master/examples/models/1B5F-carb.cif");
  InputStream inStream=url.openStream();
  MMcifParser parser=new SimpleMMcifParser();
  SimpleMMcifConsumer consumer=new SimpleMMcifConsumer();
  parser.addMMcifConsumer(consumer);
  parser.parse(new BufferedReader(new InputStreamReader(inStream)));
  Structure structure=consumer.getStructure();
  AdapterToStructureData writerToEncoder=new AdapterToStructureData();
  new MmtfStructureWriter(structure,writerToEncoder);
  MmtfStructureReader mmtfStructureReader=new MmtfStructureReader();
  new StructureDataToAdapter(writerToEncoder,mmtfStructureReader);
  Structure structure2=mmtfStructureReader.getStructure();
  assertEquals(7,structure2.getEntityInfos().size());
  assertEquals(2,structure2.getEntityById(1).getChains().size());
  assertEquals(2,structure2.getEntityById(2).getChains().size());
  assertEquals(4,structure2.getNonPolyChains().size());
  assertEquals(4,structure2.getPolyChains().size());
  assertEquals(1,structure2.getEntityById(3).getChains().size());
  assertSame(structure2.getNonPolyChain("E"),structure2.getEntityById(3).getChains().get(0));
  assertEquals(5,structure2.getNonPolyChain("E").getAtomGroups().size());
}
