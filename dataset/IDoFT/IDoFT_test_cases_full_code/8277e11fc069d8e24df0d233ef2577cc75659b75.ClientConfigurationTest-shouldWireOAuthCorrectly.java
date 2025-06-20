@Test public void shouldWireOAuthCorrectly(){
  assertThat(exampleRest,is(notNullValue()));
  assertThat(exampleRestTemplate,is(notNullValue()));
  assertThat(exampleAsyncRestTemplate,is(notNullValue()));
}
