@Test public void should_validate_entity_constrained_on_property() throws Exception {
assertThat(found).isNotNull();
assertThat(found.getName()).isEqualTo("name");
}