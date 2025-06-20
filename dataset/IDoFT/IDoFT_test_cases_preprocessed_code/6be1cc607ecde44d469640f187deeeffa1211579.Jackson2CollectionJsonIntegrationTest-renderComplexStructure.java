@Test void renderComplexStructure() throws Exception {
assertThat(mapper.writeObject(resources)).isEqualTo(mapper.readFileContent("resources-with-resource-objects.json"));
}