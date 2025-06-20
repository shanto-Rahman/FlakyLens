@Test public void should_query_using_index_and_clustering_column() throws Exception {
assertThat(actual).hasSize(1);
assertThat(entity.getSimpleIndex()).isEqualTo("312");
}