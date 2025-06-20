@Test public void shouldReturnValuesFromStaticObjectBuilder(){
assertThat(jsonBody.getValue(),is("{\"fieldOne\":\"valueOne\",\"fieldTwo\":\"valueTwo\"}"));
assertThat(jsonBody.getType(),is(Body.Type.JSON));
assertThat(jsonBody.getMatchType(),is(ONLY_MATCHING_FIELDS));
assertThat(jsonBody.getContentType(),is("application/json; charset=utf-8"));
}