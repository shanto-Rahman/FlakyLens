@Test public void shouldPersistExpectationsToJsonOnUpdate() throws Exception {
assertThat(persistedExpectations.getAbsolutePath() + " does not match expected content",new String(Files.readAllBytes(persistedExpectations.toPath()),StandardCharsets.UTF_8),is(expectedFileContents));
if (expectationFileSystemPersistence != null) {
}
}