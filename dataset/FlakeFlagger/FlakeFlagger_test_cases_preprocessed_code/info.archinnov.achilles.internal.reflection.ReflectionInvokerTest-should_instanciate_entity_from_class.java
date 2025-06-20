@Test public void should_instanciate_entity_from_class() throws Exception {
assertThat(actual).isNotNull();
assertThat(actual.getUserId()).isNull();
assertThat(actual.getName()).isNull();
}