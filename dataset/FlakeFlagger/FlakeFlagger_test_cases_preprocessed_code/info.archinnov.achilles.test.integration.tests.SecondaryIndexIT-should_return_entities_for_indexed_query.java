@Test public void should_return_entities_for_indexed_query() throws Exception {
assertThat(actual).hasSize(1);
assertThat(found1).isNotNull();
}