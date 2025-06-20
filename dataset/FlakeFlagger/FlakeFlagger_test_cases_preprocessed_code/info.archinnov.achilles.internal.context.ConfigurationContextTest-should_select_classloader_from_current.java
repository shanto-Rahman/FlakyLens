@Test public void should_select_classloader_from_current() throws Exception {
assertThat(actual).isSameAs(this.getClass().getClassLoader());
}