@Test public void should_validate_entity_constrained_on_class() throws Exception {
assertThat(found).isNotNull();
assertThat(found.getFirstname()).isEqualTo("firstname");
assertThat(found.getLastname()).isEqualTo("lastname");
}