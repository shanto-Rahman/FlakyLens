@Test void renderSimplePojos() throws Exception {
  List<EntityModel<SimplePojo>> data=new ArrayList<>();
  data.add(EntityModel.of(new SimplePojo("text",1),Link.of("localhost"),Link.of("orders").withRel("orders")));
  data.add(EntityModel.of(new SimplePojo("text2",2),Link.of("localhost")));
  CollectionModel<EntityModel<SimplePojo>> resources=CollectionModel.of(data);
  resources.add(Link.of("localhost"));
  resources.add(Link.of("/page/2").withRel("next"));
  assertThat(mapper.writeObject(resources)).isEqualTo(mapper.readFileContent("resources-simple-pojos.json"));
}
