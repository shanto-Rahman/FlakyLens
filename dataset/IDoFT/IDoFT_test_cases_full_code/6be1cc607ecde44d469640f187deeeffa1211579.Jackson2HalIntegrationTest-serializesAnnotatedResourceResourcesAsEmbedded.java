/** 
 * @see #47, #60
 */
@Test void serializesAnnotatedResourceResourcesAsEmbedded() throws Exception {
  List<EntityModel<SimpleAnnotatedPojo>> content=new ArrayList<>();
  content.add(EntityModel.of(new SimpleAnnotatedPojo("test1",1),Link.of("localhost")));
  CollectionModel<EntityModel<SimpleAnnotatedPojo>> resources=CollectionModel.of(content);
  resources.add(Link.of("localhost"));
  assertThat(mapper.writeValueAsString(resources)).isEqualTo(ANNOTATED_EMBEDDED_RESOURCE_REFERENCE);
}
