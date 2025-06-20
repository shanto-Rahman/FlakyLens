@Test public void jacksonMetaAnnotated() throws Exception {
  String json="{\"X\":1,\"A\":1,\"B\":true}";
  String jsonRegex="\\{(?:\"X\":1,(?:\"A\":1,\"B\":true|\"B\":true,\"A\":1)|" + "\"B\":true,(?:\"X\":1,\"A\":1|\"A\":1,\"X\":1)|" + "\"A\":1,(?:\"B\":true,\"X\":1|\"X\":1,\"B\":true))}";
  ImmutableJacksonUsingMeta value=OBJECT_MAPPER.readValue(json,ImmutableJacksonUsingMeta.class);
  check(OBJECT_MAPPER.writeValueAsString(value)).matches(jsonRegex);
}
