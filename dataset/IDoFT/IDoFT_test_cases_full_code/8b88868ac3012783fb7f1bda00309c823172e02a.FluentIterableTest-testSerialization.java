public void testSerialization() throws Exception {
  String json=MAPPER.writeValueAsString(createFluentIterable());
  assertEquals("[1,2,3]",json);
}
