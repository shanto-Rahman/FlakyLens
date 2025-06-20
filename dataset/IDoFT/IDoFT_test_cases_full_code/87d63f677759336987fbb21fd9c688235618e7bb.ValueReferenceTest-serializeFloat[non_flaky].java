@Test public void serializeFloat() throws IOException {
  assertJsonEqualsNonStrict(objectMapper.writeValueAsString(ValueReference.of(1.0f)),"{\"@type\":\"float\",\"@value\":1.0}");
  assertJsonEqualsNonStrict(objectMapper.writeValueAsString(ValueReference.of(42.4f)),"{\"@type\":\"float\",\"@value\":42.4}");
}
