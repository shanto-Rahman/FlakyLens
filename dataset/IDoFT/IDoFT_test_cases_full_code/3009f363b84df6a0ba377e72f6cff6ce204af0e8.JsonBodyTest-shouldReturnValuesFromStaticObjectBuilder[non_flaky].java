@Test public void shouldReturnValuesFromStaticObjectBuilder(){
  JsonBody jsonBody=json(new TestObject());
  assertJsonEqualsNonStrict(jsonBody.getValue(),"{\"fieldOne\":\"valueOne\",\"fieldTwo\":\"valueTwo\"}");
  assertThat(jsonBody.getType(),is(Body.Type.JSON));
  assertThat(jsonBody.getMatchType(),is(ONLY_MATCHING_FIELDS));
  assertThat(jsonBody.getContentType(),is("application/json; charset=utf-8"));
}
