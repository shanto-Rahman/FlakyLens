@Test public void serializeBoolean() throws IOException {
  assertJsonEqualsNonStrict(objectMapper.writeValueAsString(ValueReference.of(true)),"{\"@type\":\"boolean\",\"@value\":true}");
  assertJsonEqualsNonStrict(objectMapper.writeValueAsString(ValueReference.of(false)),"{\"@type\":\"boolean\",\"@value\":false}");
}
