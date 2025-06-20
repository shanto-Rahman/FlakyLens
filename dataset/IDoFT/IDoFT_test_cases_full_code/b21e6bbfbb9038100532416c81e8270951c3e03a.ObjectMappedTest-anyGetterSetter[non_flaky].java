@Test public void anyGetterSetter() throws Exception {
  String json="{\"A\":1,\"B\":true}";
  String jsonRegex="\\{(?:\"A\":1,\"B\":true|\"B\":true,\"A\":1)}";
  AnyGetterSetter value=OBJECT_MAPPER.readValue(json,AnyGetterSetter.class);
  check(OBJECT_MAPPER.writeValueAsString(value)).matches(jsonRegex);
}
