@Test public void returnsRepositoryHandlerMethodWithBaseUriConfigured() throws Exception {
assertThat(method).isNotNull();
assertThat(method.getMethod()).isEqualTo(listEntitiesMethod);
}