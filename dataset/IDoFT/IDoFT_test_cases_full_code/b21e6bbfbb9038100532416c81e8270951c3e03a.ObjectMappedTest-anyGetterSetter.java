@Test public void anyGetterSetter() throws Exception {
  String json="{\"A\":1,\"B\":true}";
  AnyGetterSetter value=OBJECT_MAPPER.readValue(json,AnyGetterSetter.class);
  check(OBJECT_MAPPER.writeValueAsString(value)).is(json);
}
