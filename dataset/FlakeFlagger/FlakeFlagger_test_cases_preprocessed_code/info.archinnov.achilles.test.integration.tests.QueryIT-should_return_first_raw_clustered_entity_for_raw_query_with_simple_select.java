@Test public void should_return_first_raw_clustered_entity_for_raw_query_with_simple_select() throws Exception {
assertThat(actual).isNotNull();
assertThat(clusteredKey).isNotNull();
assertThat(clusteredKey.getId()).isEqualTo(id);
assertThat(clusteredKey.getCount()).isEqualTo(10);
assertThat(clusteredKey.getName()).isEqualTo("name");
}