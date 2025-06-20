@Test void rendersMultipleResourceResourcesAsEmbedded() throws Exception {
  CollectionModel<EntityModel<SimplePojo>> resources=setupResources();
  resources.add(Link.of("localhost"));
  assertThat(mapper.writeObject(resources)).isEqualTo(mapper.readFileContent("multiple-resource-resources.json"));
}
