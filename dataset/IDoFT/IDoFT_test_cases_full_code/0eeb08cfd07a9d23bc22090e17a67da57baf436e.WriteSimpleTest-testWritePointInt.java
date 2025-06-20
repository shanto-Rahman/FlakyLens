public void testWritePointInt() throws Exception {
  ProtobufSchema schema=ProtobufSchemaLoader.std.parse(PROTOC_BOX,"Point");
  final ObjectWriter w=MAPPER.writerFor(Point.class).with(schema);
  Point input=new Point(7,2);
  byte[] bytes=w.writeValueAsBytes(input);
  assertNotNull(bytes);
  assertEquals(4,bytes.length);
  assertEquals(8,bytes[0]);
  assertEquals(7,bytes[1]);
  assertEquals(0x10,bytes[2]);
  assertEquals(4,bytes[3]);
  Point result=MAPPER.readerFor(Point.class).with(schema).readValue(bytes);
  assertEquals(input,result);
}
