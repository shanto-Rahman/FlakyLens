@Test public void should_validate_entity_constrained_on_field() throws Exception {
assertThat(found).isNotNull();
assertThat(found.getName()).isEqualTo("name");
}