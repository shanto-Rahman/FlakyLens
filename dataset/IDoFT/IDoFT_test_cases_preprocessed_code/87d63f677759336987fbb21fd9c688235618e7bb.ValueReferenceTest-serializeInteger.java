@Test public void serializeInteger() throws IOException {
assertThat(objectMapper.writeValueAsString(ValueReference.of(1))).isEqualTo("{\"@type\":\"integer\",\"@value\":1}");
assertThat(objectMapper.writeValueAsString(ValueReference.of(42))).isEqualTo("{\"@type\":\"integer\",\"@value\":42}");
}