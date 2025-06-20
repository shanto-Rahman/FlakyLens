@Test public void shouldReturnColumnNameWithBothPrefixAndSuffix() throws Exception {
assertThat(nameResolver.getTableName(TableName.LOGGING_EVENT)).isEqualTo("logging_event");
assertThat(nameResolver.getColumnName(ColumnName.THREAD_NAME)).isEqualTo("cp_thread_name_cs");
}