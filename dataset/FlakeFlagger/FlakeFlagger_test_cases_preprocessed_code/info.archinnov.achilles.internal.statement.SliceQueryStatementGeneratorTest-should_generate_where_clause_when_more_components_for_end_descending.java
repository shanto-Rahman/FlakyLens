@Test public void should_generate_where_clause_when_more_components_for_end_descending() throws Exception {
assertThat(statement.getStatement().getQueryString()).isEqualTo("SELECT test FROM table WHERE id=11 AND a=? AND b=? AND c>=1;");
assertThat(statement.getValues()).contains(uuid1,"author");
assertThat(statement.getStatement().getFetchSize()).isEqualTo(99);
assertThat(statement.getStatement().getQueryString()).isEqualTo("SELECT test FROM table WHERE id=11 AND a=? AND b=? AND c>1;");
assertThat(statement.getValues()).contains(uuid1,"author");
assertThat(statement.getStatement().getFetchSize()).isEqualTo(99);
assertThat(statement.getStatement().getQueryString()).isEqualTo("SELECT test FROM table WHERE id=11 AND a=? AND b=? AND c>1;");
assertThat(statement.getValues()).contains(uuid1,"author");
assertThat(statement.getStatement().getFetchSize()).isEqualTo(99);
assertThat(statement.getStatement().getQueryString()).isEqualTo("SELECT test FROM table WHERE id=11 AND a=? AND b=? AND c>=1;");
assertThat(statement.getValues()).contains(uuid1,"author");
assertThat(statement.getStatement().getFetchSize()).isEqualTo(99);
assertThat(statement.getStatement().getConsistencyLevel()).isEqualTo(EACH_QUORUM);
assertThat(statement.getStatement().getSerialConsistencyLevel()).isNull();
}