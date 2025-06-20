@Test public void should_query_using_map_key_value() throws Exception {
assertThat(actual).hasSize(1);
assertThat(entity.getSimpleIndex()).isEqualTo("211");
}