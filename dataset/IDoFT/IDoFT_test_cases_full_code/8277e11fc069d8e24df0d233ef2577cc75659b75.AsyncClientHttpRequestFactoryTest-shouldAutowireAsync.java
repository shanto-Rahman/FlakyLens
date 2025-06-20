@Test public void shouldAutowireAsync(){
  assertThat(async.getClass(),is(RestAsyncClientHttpRequestFactory.class));
}
