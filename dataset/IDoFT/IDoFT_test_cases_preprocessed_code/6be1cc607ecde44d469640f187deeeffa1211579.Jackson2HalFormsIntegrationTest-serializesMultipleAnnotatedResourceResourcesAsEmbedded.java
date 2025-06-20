@Test void serializesMultipleAnnotatedResourceResourcesAsEmbedded() throws Exception {
assertThat(mapper.writeObject(setupAnnotatedResources())).isEqualTo(mapper.readFileContent("annotated-embedded-resources-reference.json"));
}