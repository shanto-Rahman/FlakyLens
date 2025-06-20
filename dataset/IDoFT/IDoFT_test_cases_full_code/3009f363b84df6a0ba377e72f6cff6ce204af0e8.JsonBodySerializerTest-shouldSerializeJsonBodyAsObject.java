@Test public void shouldSerializeJsonBodyAsObject() throws JsonProcessingException {
  assertThat(ObjectMapperFactory.createObjectMapper().writeValueAsString(json(new TestObject())),is("{\"type\":\"JSON\",\"json\":{\"fieldOne\":\"valueOne\",\"fieldTwo\":\"valueTwo\"}}"));
}
