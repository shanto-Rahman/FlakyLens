@Test public void serializeBoolean() throws IOException {
  assertThat(objectMapper.writeValueAsString(ValueReference.of(true))).isEqualTo("{\"@type\":\"boolean\",\"@value\":true}");
  assertThat(objectMapper.writeValueAsString(ValueReference.of(false))).isEqualTo("{\"@type\":\"boolean\",\"@value\":false}");
}
