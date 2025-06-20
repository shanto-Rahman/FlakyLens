@Test public void serializeParameter() throws IOException {
  assertJsonEqualsNonStrict(objectMapper.writeValueAsString(ValueReference.createParameter("Test")),"{\"@type\":\"parameter\",\"@value\":\"Test\"}");
}
