public void testSimpleShort() throws Exception {
  final ObjectWriter w=MAPPER.writer(NAME_SCHEMA);
  byte[] bytes=w.writeValueAsBytes(new Name("Bob","Burger"));
  assertEquals(13,bytes.length);
  assertEquals(13,bytes.length);
  assertEquals(0x12,bytes[0]);
  assertEquals(3,bytes[1]);
  assertEquals((byte)'B',bytes[2]);
  assertEquals((byte)'o',bytes[3]);
  assertEquals((byte)'b',bytes[4]);
  assertEquals(0x3A,bytes[5]);
  assertEquals(6,bytes[6]);
  assertEquals((byte)'B',bytes[7]);
  assertEquals((byte)'u',bytes[8]);
  assertEquals((byte)'r',bytes[9]);
  assertEquals((byte)'g',bytes[10]);
  assertEquals((byte)'e',bytes[11]);
  assertEquals((byte)'r',bytes[12]);
}
