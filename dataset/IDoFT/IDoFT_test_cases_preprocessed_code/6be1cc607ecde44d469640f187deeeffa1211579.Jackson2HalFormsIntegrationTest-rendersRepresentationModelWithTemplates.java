@Test void rendersRepresentationModelWithTemplates() throws Exception {
assertThat(mapper.writeObject(resource)).isEqualTo(mapper.readFileContent("employee-resource-support.json"));
}