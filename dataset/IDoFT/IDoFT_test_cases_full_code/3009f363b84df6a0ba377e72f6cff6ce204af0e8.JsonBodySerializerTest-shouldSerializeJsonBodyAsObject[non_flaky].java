@Test public void shouldSerializeJsonBodyAsObject() throws JsonProcessingException {
  String actual=ObjectMapperFactory.createObjectMapper().writeValueAsString(json(new TestObject()));
  String expectedCase1="{\"type\":\"JSON\",\"json\":{\"fieldOne\":\"valueOne\",\"fieldTwo\":\"valueTwo\"}}";
  String expectedCase2="{\"type\":\"JSON\",\"json\":{\"fieldTwo\":\"valueTwo\",\"fieldOne\":\"valueOne\"}}";
  assertTrue(actual.equals(expectedCase1) || actual.equals(expectedCase2));
}
