public void testWriteCoord() throws Exception {
  ProtobufSchema schema=ProtobufSchemaLoader.std.parse(PROTOC_BOX,"Box");
  schema=schema.withRootType("Box");
  final ObjectWriter w=MAPPER.writerFor(Box.class).with(schema);
  byte[] bytes=w.writeValueAsBytes(new Box(0x3F,0x11,0x18,0xF));
  assertNotNull(bytes);
  assertEquals(12,bytes.length);
  assertEquals(0x1A,bytes[0]);
  assertEquals(0x4,bytes[1]);
  assertEquals(0x8,bytes[2]);
  assertEquals(0x3F,bytes[3]);
  assertEquals(0x10,bytes[4]);
  assertEquals(0x22,bytes[5]);
  assertEquals(0x2A,bytes[6]);
  assertEquals(0x4,bytes[7]);
  assertEquals(0x8,bytes[8]);
  assertEquals(0x18,bytes[9]);
  assertEquals(0x10,bytes[10]);
  assertEquals(0x1E,bytes[11]);
}
