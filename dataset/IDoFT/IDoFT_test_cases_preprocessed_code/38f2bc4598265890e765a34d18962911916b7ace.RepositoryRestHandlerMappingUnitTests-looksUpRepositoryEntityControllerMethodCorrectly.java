@Test public void looksUpRepositoryEntityControllerMethodCorrectly() throws Exception {
assertThat(method).isNotNull();
assertThat(method.getMethod()).isEqualTo(listEntitiesMethod);
}