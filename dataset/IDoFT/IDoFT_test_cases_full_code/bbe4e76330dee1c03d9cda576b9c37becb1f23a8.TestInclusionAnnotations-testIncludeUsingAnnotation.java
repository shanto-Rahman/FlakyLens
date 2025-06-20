public void testIncludeUsingAnnotation() throws Exception {
  ObjectMapper mapper=mapperWithModule();
  String json=mapper.writeValueAsString(new IntWrapper(3));
  assertEquals("{\"value\":3}",json);
  json=mapper.writeValueAsString(new IntWrapper(null));
  assertEquals("{}",json);
  json=mapper.writeValueAsString(new AnyWrapper(new IntWrapper(null)));
  assertEquals("{\"name\":\"Foo\",\"wrapped\":{}}",json);
  json=mapper.writeValueAsString(new AnyWrapper(null));
  assertEquals("{\"name\":\"Foo\"}",json);
}
