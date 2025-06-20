@Test void serializesPagedResource() throws Exception {
  assertThat(mapper.writeObject(setupAnnotatedPagedResources())).isEqualTo(mapper.readFileContent("paged-resources.json"));
}
