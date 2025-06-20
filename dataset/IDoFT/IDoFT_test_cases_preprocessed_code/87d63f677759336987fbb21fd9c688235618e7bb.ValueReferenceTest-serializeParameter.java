@Test public void serializeParameter() throws IOException {
assertThat(objectMapper.writeValueAsString(ValueReference.createParameter("Test"))).isEqualTo("{\"@type\":\"parameter\",\"@value\":\"Test\"}");
}