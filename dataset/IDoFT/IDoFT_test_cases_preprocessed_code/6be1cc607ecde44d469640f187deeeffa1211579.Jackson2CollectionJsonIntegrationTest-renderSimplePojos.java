@Test void renderSimplePojos() throws Exception {
assertThat(mapper.writeObject(resources)).isEqualTo(mapper.readFileContent("resources-simple-pojos.json"));
}