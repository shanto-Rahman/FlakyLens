@Test public void uninstallAll() throws Exception {
assertThat(getNamesOfFilesInLib(),containsInAnyOrder("alpha.jar","bravo.jar","charlie.jar",".installed"));
assertThat(getNamesOfFilesInLib(),containsInAnyOrder(".installed"));
}