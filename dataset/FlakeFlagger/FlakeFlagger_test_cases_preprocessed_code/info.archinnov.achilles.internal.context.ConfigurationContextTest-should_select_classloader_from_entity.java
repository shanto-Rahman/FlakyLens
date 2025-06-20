@Test public void should_select_classloader_from_entity() throws Exception {
assertThat(classLoader).isSameAs(this.getClass().getClassLoader());
}