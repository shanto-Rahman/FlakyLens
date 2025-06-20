@Test public void returnsRootHandlerMethodWithBaseUriConfigured() throws Exception {
assertThat(method).isNotNull();
assertThat(method.getMethod()).isEqualTo(rootHandlerMethod);
}