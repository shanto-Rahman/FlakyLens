@Test public void testRepository(){
assertThat(exampleGraph.getId()).isNull();
assertThat(savedGraph.getId()).isNotNull();
assertThat(this.session.countEntitiesOfType(ExampleGraph.class)).isEqualTo(1);
}