@Test public void jacksonMetaAnnotated() throws Exception {
  String json="{\"X\":1,\"A\":1,\"B\":true}";
  ImmutableJacksonUsingMeta value=OBJECT_MAPPER.readValue(json,ImmutableJacksonUsingMeta.class);
  check(OBJECT_MAPPER.writeValueAsString(value)).is(json);
}
