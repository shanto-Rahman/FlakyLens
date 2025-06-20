@Test public void should_parse_bean_with_insert_strategy() throws Exception {
assertThat(meta.getInsertStrategy()).isEqualTo(InsertStrategy.NOT_NULL_FIELDS);
}