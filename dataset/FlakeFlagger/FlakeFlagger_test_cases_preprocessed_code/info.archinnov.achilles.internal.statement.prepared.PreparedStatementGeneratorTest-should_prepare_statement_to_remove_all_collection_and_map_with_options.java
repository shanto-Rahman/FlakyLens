@Test public void should_prepare_statement_to_remove_all_collection_and_map_with_options() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(regularStatementCaptor.getValue().getQueryString()).isEqualTo("UPDATE table USING TTL :ttl AND TIMESTAMP :timestamp SET followers=:followers WHERE id=:id IF name=:name;");
}