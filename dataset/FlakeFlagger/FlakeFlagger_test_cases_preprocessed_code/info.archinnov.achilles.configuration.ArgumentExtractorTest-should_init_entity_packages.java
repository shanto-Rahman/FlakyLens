@Test public void should_init_entity_packages() throws Exception {
assertThat(actual).containsOnly(Entity1.class,Entity2.class,Entity3.class);
}