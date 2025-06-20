@Test public void serializeString() throws IOException {
  assertJsonEqualsNonStrict(objectMapper.writeValueAsString(ValueReference.of("")),"{\"@type\":\"string\",\"@value\":\"\"}");
  assertJsonEqualsNonStrict(objectMapper.writeValueAsString(ValueReference.of("Test")),"{\"@type\":\"string\",\"@value\":\"Test\"}");
}
