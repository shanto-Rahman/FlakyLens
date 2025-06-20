@Test void renderComplexStructure() throws Exception {
  List<EntityModel<String>> data=new ArrayList<>();
  data.add(EntityModel.of("first",Link.of("localhost"),Link.of("orders").withRel("orders")));
  data.add(EntityModel.of("second",Link.of("remotehost"),Link.of("order").withRel("orders")));
  CollectionModel<EntityModel<String>> resources=CollectionModel.of(data);
  resources.add(Link.of("localhost"));
  resources.add(Link.of("/page/2").withRel("next"));
  assertThat(mapper.writeObject(resources)).isEqualTo(mapper.readFileContent("resources-with-resource-objects.json"));
}
