@Test public void should_init_osgi_classloader() throws Exception {
assertThat(actual).isSameAs(this.getClass().getClassLoader());
}