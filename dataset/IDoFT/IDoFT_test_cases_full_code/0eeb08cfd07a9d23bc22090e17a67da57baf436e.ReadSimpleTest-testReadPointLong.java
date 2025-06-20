public void testReadPointLong() throws Exception {
  ProtobufSchema schema=ProtobufSchemaLoader.std.parse(PROTOC_POINT_L);
  final ObjectWriter w=MAPPER.writerFor(Point.class).with(schema);
  Point input=new Point(Integer.MAX_VALUE,Integer.MIN_VALUE);
  byte[] bytes=w.writeValueAsBytes(input);
  assertNotNull(bytes);
  assertEquals(12,bytes.length);
  Point result=MAPPER.readerFor(Point.class).with(schema).readValue(bytes);
  assertNotNull(result);
  assertEquals(input.x,result.x);
  assertEquals(input.y,result.y);
  JsonParser p=MAPPER.reader().with(schema).createParser(bytes);
  assertToken(JsonToken.START_OBJECT,p.nextToken());
  assertToken(JsonToken.PROPERTY_NAME,p.nextToken());
  assertEquals("x",p.currentName());
  assertToken(JsonToken.VALUE_NUMBER_INT,p.nextToken());
  assertEquals(input.x,p.getIntValue());
  assertToken(JsonToken.PROPERTY_NAME,p.nextToken());
  assertEquals("y",p.currentName());
  assertToken(JsonToken.VALUE_NUMBER_INT,p.nextToken());
  assertEquals(input.y,p.getIntValue());
  assertToken(JsonToken.END_OBJECT,p.nextToken());
  p.close();
}
