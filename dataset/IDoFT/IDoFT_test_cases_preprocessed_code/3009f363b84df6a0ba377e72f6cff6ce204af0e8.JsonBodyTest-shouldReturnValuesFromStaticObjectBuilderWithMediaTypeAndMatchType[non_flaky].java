@Test public void shouldReturnValuesFromStaticObjectBuilderWithMediaTypeAndMatchType(){
assertThat(jsonBody.getType(),is(Body.Type.JSON));
assertThat(jsonBody.getMatchType(),is(STRICT));
assertThat(jsonBody.getContentType(),is("application/json; charset=utf-16"));
}