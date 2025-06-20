@Test public void should_prepare_statement_to_remove_entry_from_map() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(regularStatementCaptor.getValue().getQueryString()).isEqualTo("UPDATE table USING TTL :ttl SET preferences[:key]=:nullValue WHERE id=:id;");
}