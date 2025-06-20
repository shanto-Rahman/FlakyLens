@Test public void replacesServiceLocator() throws Exception {
assertThat(resolver,instanceOf(SpringPackageScanClassResolver.class));
}