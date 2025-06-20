@Test public void testRepository(){
  ExampleGraph exampleGraph=new ExampleGraph();
  exampleGraph.setDescription("Look, new @DataNeo4jTest!");
  assertThat(exampleGraph.getId()).isNull();
  ExampleGraph savedGraph=this.exampleRepository.save(exampleGraph);
  assertThat(savedGraph.getId()).isNotNull();
  assertThat(this.session.countEntitiesOfType(ExampleGraph.class)).isEqualTo(1);
}
