@Test public void shouldAutowireSync(){
assertThat(sync.getClass(),is(RestAsyncClientHttpRequestFactory.class));
}