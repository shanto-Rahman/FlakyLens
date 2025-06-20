@Test public void shouldReturnColumnNameWithSuffix() throws Exception {
assertThat(nameResolver.getTableName(TableName.LOGGING_EVENT)).isEqualTo("logging_event");
assertThat(nameResolver.getColumnName(ColumnName.THREAD_NAME)).isEqualTo("thread_name_cs");
}