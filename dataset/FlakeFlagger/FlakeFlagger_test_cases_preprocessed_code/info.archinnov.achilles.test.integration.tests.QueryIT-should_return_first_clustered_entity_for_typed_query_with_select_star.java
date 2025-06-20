@Test public void should_return_first_clustered_entity_for_typed_query_with_select_star() throws Exception {
assertThat(actual).isNotNull();
assertThat(actual).isInstanceOf(Factory.class);
assertThat(clusteredKey).isNotNull();
assertThat(clusteredKey.getId()).isEqualTo(id);
assertThat(clusteredKey.getCount()).isEqualTo(10);
assertThat(clusteredKey.getName()).isEqualTo("name");
}