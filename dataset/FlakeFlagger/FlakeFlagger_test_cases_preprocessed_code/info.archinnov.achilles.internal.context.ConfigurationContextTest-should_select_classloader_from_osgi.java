@Test public void should_select_classloader_from_osgi() throws Exception {
assertThat(classLoader).isSameAs(osgiClassLoader);
}