@Test void serializesAnnotatedResourceResourcesAsEmbedded() throws Exception {
assertThat(mapper.writeObject(resources)).isEqualTo(mapper.readFileContent("annotated-resource-resources.json"));
}