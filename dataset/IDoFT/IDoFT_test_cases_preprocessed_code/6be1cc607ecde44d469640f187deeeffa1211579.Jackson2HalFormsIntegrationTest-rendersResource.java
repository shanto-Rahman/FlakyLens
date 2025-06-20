@Test void rendersResource() throws Exception {
assertThat(mapper.writeObject(resource)).isEqualTo(mapper.readFileContent("simple-resource-unwrapped.json"));
}