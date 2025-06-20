@Test void rendersMultipleCuries() throws Exception {
assertThat(getCuriedObjectMapper(provider).writeObject(resources)).isEqualTo(mapper.readFileContent("multiple-curies-document.json"));
}