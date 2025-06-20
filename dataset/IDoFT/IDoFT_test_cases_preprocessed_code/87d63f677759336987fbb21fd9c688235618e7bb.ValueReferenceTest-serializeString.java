@Test public void serializeString() throws IOException {
assertThat(objectMapper.writeValueAsString(ValueReference.of(""))).isEqualTo("{\"@type\":\"string\",\"@value\":\"\"}");
assertThat(objectMapper.writeValueAsString(ValueReference.of("Test"))).isEqualTo("{\"@type\":\"string\",\"@value\":\"Test\"}");
}