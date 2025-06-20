@Test public void should_prepare_statement_to_append_elements_to_list() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(regularStatementCaptor.getValue().getQueryString()).isEqualTo("UPDATE table USING TTL :ttl SET friends=friends+:friends WHERE id=:id;");
}