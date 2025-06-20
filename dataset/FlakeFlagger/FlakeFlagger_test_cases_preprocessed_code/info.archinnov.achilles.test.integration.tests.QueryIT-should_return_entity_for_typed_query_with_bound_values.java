@Test public void should_return_entity_for_typed_query_with_bound_values() throws Exception {
assertThat(actual).hasSize(1);
assertThat(found.getName()).isEqualTo(entity.getName());
}