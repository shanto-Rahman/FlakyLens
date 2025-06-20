public void testStringArrayWithName() throws Exception {
  ProtobufSchema schema=ProtobufSchemaLoader.std.parse(PROTOC_NAMED_STRINGS);
  final ObjectWriter w=MAPPER.writerFor(NamedStrings.class).with(schema);
  NamedStrings input=new NamedStrings("abc123","a","b","","d");
  byte[] bytes=w.writeValueAsBytes(input);
  assertNotNull(bytes);
  assertEquals(19,bytes.length);
  NamedStrings result=MAPPER.readerFor(NamedStrings.class).with(schema).readValue(bytes);
  assertNotNull(result);
  assertEquals(input.name,result.name);
  assertNotNull(result.values);
  assertEquals(input.values.length,result.values.length);
  for (int i=0; i < result.values.length; ++i) {
    assertEquals(input.values[i],result.values[i]);
  }
  JsonParser p=MAPPER.reader().with(schema).createParser(bytes);
  assertToken(JsonToken.START_OBJECT,p.nextToken());
  assertToken(JsonToken.PROPERTY_NAME,p.nextToken());
  assertEquals("name",p.currentName());
  assertToken(JsonToken.VALUE_STRING,p.nextToken());
  assertEquals(input.name,p.getText());
  assertToken(JsonToken.PROPERTY_NAME,p.nextToken());
  assertEquals("values",p.currentName());
  assertToken(JsonToken.START_ARRAY,p.nextToken());
  assertToken(JsonToken.VALUE_STRING,p.nextToken());
  assertFalse(p.hasTextCharacters());
  assertEquals(input.values[0],p.getText());
  assertToken(JsonToken.VALUE_STRING,p.nextToken());
  assertEquals(input.values[1],p.getText());
  assertToken(JsonToken.VALUE_STRING,p.nextToken());
  assertEquals(input.values[2],p.getText());
  assertToken(JsonToken.VALUE_STRING,p.nextToken());
  assertEquals(input.values[3],p.getText());
  assertToken(JsonToken.END_ARRAY,p.nextToken());
  assertToken(JsonToken.END_OBJECT,p.nextToken());
  p.close();
  p=MAPPER.reader().with(schema).createParser(bytes);
  assertToken(JsonToken.START_OBJECT,p.nextToken());
  assertToken(JsonToken.PROPERTY_NAME,p.nextToken());
  assertEquals("name",p.currentName());
  ByteArrayOutputStream b=new ByteArrayOutputStream();
  int count=p.releaseBuffered(b);
  assertEquals(count,b.size());
  assertEquals(18,count);
  p.close();
}
