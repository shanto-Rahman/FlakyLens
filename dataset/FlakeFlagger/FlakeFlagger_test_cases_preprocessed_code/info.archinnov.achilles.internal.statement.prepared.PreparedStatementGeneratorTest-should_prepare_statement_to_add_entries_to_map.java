@Test public void should_prepare_statement_to_add_entries_to_map() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(regularStatementCaptor.getValue().getQueryString()).isEqualTo("UPDATE table USING TTL :ttl SET preferences=preferences+:preferences WHERE id=:id;");
}