@Test public void shouldReturnValuesFromStaticObjectBuilderWithCharsetAndMatchType(){
  JsonBody jsonBody=json(new TestObject(),StandardCharsets.UTF_16,STRICT);
  assertJsonEqualsNonStrict(jsonBody.getValue(),"{\"fieldOne\":\"valueOne\",\"fieldTwo\":\"valueTwo\"}");
  assertThat(jsonBody.getType(),is(Body.Type.JSON));
  assertThat(jsonBody.getMatchType(),is(STRICT));
  assertThat(jsonBody.getContentType(),is("application/json; charset=utf-16"));
}
