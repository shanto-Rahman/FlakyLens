@Test public void installNewDependency() throws Exception {
assertThat(getNamesOfFilesInLib(),containsInAnyOrder("foo.jar",".installed"));
}