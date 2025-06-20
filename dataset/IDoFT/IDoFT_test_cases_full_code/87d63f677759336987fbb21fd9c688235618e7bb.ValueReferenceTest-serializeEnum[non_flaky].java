@Test public void serializeEnum() throws IOException {
  assertJsonEqualsNonStrict(objectMapper.writeValueAsString(ValueReference.of(TestEnum.A)),"{\"@type\":\"string\",\"@value\":\"A\"}");
  assertJsonEqualsNonStrict(objectMapper.writeValueAsString(ValueReference.of(TestEnum.B)),"{\"@type\":\"string\",\"@value\":\"B\"}");
}
