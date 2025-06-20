@Test public void returnsRepositoryHandlerMethodForAbsoluteBaseUriWithServletMapping() throws Exception {
assertThat(method).isNotNull();
assertThat(method.getMethod()).isEqualTo(listEntitiesMethod);
}