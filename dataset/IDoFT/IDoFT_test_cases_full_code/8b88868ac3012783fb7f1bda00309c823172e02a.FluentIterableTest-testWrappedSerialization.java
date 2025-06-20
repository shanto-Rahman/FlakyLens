public void testWrappedSerialization() throws Exception {
  FluentHolder holder=new FluentHolder();
  String json=MAPPER.writeValueAsString(holder);
  assertEquals("{\"value\":[1,2,3]}",json);
}
