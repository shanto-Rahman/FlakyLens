@Test public void shouldReturnSimpleSqlInsertLoggingEventQuery() throws Exception {
assertThat(sql).isEqualTo(expected);
}