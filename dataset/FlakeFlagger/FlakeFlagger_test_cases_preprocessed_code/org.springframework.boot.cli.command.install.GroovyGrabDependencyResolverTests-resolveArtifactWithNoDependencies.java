@Test public void resolveArtifactWithNoDependencies() throws Exception {
assertThat(resolved,hasSize(1));
assertThat(getNames(resolved),hasItems("commons-logging-1.1.3.jar"));
}