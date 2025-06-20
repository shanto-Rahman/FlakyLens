@Test public void should_query_using_simple_index() throws Exception {
assertThat(actual).hasSize(1);
assertThat(entity.getFullIndexOnCollection()).containsExactly("313");
}