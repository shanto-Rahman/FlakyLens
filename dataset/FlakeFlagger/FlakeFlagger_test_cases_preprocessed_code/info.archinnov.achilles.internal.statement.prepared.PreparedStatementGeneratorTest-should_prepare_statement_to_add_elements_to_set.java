@Test public void should_prepare_statement_to_add_elements_to_set() throws Exception {
assertThat(actual).isSameAs(ps);
assertThat(regularStatementCaptor.getValue().getQueryString()).isEqualTo("UPDATE table USING TTL :ttl SET followers=followers+:followers WHERE id=:id;");
}