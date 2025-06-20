@Test public void should_query_using_map_key_index() throws Exception {
assertThat(actual).hasSize(1);
assertThat(entity.getSimpleIndex()).isEqualTo("312");
}