@Test void serializesAnnotatedResourceResourcesAsEmbedded() throws Exception {
  List<EntityModel<SimpleAnnotatedPojo>> content=new ArrayList<>();
  content.add(EntityModel.of(new SimpleAnnotatedPojo("test1",1),Link.of("localhost")));
  CollectionModel<EntityModel<SimpleAnnotatedPojo>> resources=CollectionModel.of(content);
  resources.add(Link.of("localhost"));
  assertThat(mapper.writeObject(resources)).isEqualTo(mapper.readFileContent("annotated-resource-resources.json"));
}
