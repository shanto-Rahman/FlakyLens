@Test void rendersCuriesCorrectly() throws Exception {
assertThat(getCuriedObjectMapper().writeObject(resources)).isEqualTo(mapper.readFileContent("curied-document.json"));
}