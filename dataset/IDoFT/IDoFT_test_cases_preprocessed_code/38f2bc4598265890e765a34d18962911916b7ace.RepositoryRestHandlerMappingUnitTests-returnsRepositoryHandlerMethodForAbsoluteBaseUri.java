@Test public void returnsRepositoryHandlerMethodForAbsoluteBaseUri() throws Exception {
assertThat(method).isNotNull();
assertThat(method.getMethod()).isEqualTo(listEntitiesMethod);
}