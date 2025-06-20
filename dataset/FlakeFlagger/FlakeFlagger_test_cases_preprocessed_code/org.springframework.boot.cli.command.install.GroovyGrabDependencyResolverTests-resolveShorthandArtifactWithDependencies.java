@SuppressWarnings("unchecked") @Test public void resolveShorthandArtifactWithDependencies() throws Exception {
assertThat(resolved,hasSize(2));
assertThat(getNames(resolved),hasItems(startsWith("commons-logging-"),startsWith("spring-core-")));
}