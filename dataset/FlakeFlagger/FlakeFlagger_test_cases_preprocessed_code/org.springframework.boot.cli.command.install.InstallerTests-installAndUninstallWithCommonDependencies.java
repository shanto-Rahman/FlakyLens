@Test public void installAndUninstallWithCommonDependencies() throws Exception {
assertThat(getNamesOfFilesInLib(),containsInAnyOrder("alpha.jar","bravo.jar",".installed"));
assertThat(getNamesOfFilesInLib(),containsInAnyOrder("alpha.jar","bravo.jar","charlie.jar",".installed"));
assertThat(getNamesOfFilesInLib(),containsInAnyOrder("alpha.jar","charlie.jar",".installed"));
assertThat(getNamesOfFilesInLib(),containsInAnyOrder(".installed"));
}