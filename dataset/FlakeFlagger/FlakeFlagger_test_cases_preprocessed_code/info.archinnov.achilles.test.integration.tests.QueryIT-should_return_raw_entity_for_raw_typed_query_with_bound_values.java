@Test public void should_return_raw_entity_for_raw_typed_query_with_bound_values() throws Exception {
assertThat(actual).hasSize(1);
assertThat(actual.get(0).getName()).isEqualTo(entity.getName());
}