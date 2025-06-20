@Test public void runWithIsolatedClassLoader() throws Exception {
assertThat(output,containsString("HasClasses-false-true-false"));
}