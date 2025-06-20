@Test void rendersMultipleResourceResourcesAsEmbedded() throws Exception {
assertThat(mapper.writeObject(resources)).isEqualTo(mapper.readFileContent("multiple-resource-resources.json"));
}