@Test public void serializeInteger() throws IOException {
  assertJsonEqualsNonStrict(objectMapper.writeValueAsString(ValueReference.of(1)),"{\"@type\":\"integer\",\"@value\":1}");
  assertJsonEqualsNonStrict(objectMapper.writeValueAsString(ValueReference.of(42)),"{\"@type\":\"integer\",\"@value\":42}");
}
