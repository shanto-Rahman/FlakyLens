@Test void rendersCuriesCorrectly() throws Exception {
  CollectionModel<Object> resources=CollectionModel.of(Collections.emptySet(),Link.of("foo"),Link.of("bar","myrel"));
  assertThat(getCuriedObjectMapper().writeObject(resources)).isEqualTo(mapper.readFileContent("curied-document.json"));
}
