@Test public void serializeEnum() throws IOException {
assertThat(objectMapper.writeValueAsString(ValueReference.of(TestEnum.A))).isEqualTo("{\"@type\":\"string\",\"@value\":\"A\"}");
assertThat(objectMapper.writeValueAsString(ValueReference.of(TestEnum.B))).isEqualTo("{\"@type\":\"string\",\"@value\":\"B\"}");
}