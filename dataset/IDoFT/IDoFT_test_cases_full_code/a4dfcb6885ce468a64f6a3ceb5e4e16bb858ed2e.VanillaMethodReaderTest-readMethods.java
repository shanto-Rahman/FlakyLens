@Test public void readMethods() throws IOException {
  Wire wire=new TextWire(BytesUtil.readFile("methods-in.yaml")).useTextDocuments();
  Wire wire2=new TextWire(Bytes.allocateElasticOnHeap()).useTextDocuments();
  Bytes expected=BytesUtil.readFile("methods-in.yaml");
  MockMethods writer=wire2.methodWriter(MockMethods.class);
  MethodReader reader=wire.methodReader(writer);
  for (int i=0; i < 3; i++) {
    assertTrue(reader.readOne());
  }
  assertFalse(reader.readOne());
  assertEquals(expected.toString().trim().replace("\r",""),wire2.toString().trim());
}
