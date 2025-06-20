@Test public void serializeFloat() throws IOException {
assertThat(objectMapper.writeValueAsString(ValueReference.of(1.0f))).isEqualTo("{\"@type\":\"float\",\"@value\":1.0}");
assertThat(objectMapper.writeValueAsString(ValueReference.of(42.4f))).isEqualTo("{\"@type\":\"float\",\"@value\":42.4}");
}