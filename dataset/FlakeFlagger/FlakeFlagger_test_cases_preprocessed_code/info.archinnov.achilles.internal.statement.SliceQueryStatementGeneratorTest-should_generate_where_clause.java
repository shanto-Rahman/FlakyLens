@Test public void should_generate_where_clause() throws Exception {
assertThat(statement.getStatement().getQueryString()).isEqualTo("DELETE  FROM table WHERE id=11 AND a=? AND b=?;");
}