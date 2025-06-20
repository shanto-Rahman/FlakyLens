@Test void rendersMultipleResourceResourcesAsEmbedded() throws Exception {
  CollectionModel<EntityModel<SimplePojo>> resources=setupResources();
  resources.add(Link.of("localhost"));
  assertThat(mapper.writeValueAsString(resources)).isEqualTo(LIST_EMBEDDED_RESOURCE_REFERENCE);
}
