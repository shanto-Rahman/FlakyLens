@Test public void should_query_using_collection_index() throws Exception {
assertThat(actual).hasSize(1);
assertThat(entity.getSimpleIndex()).isEqualTo("411");
}