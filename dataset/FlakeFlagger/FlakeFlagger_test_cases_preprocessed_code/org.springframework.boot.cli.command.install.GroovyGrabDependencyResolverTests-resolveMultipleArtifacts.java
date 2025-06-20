@Test public void resolveMultipleArtifacts() throws Exception {
assertThat(resolved,hasSize(3));
assertThat(getNames(resolved),hasItems("junit-4.11.jar","commons-logging-1.1.3.jar","hamcrest-core-1.3.jar"));
}