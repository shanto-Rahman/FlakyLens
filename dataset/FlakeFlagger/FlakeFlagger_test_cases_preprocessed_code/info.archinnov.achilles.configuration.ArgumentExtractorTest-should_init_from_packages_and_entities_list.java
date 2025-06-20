@Test public void should_init_from_packages_and_entities_list(){
assertThat(actual).containsOnly(Entity1.class,Entity3.class);
}