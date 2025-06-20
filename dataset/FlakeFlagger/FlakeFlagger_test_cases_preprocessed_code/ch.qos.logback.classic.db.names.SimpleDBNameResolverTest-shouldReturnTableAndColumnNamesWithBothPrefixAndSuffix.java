@Test public void shouldReturnTableAndColumnNamesWithBothPrefixAndSuffix() throws Exception {
assertThat(nameResolver.getTableName(TableName.LOGGING_EVENT)).isEqualTo("tp_logging_event_ts");
assertThat(nameResolver.getColumnName(ColumnName.THREAD_NAME)).isEqualTo("cp_thread_name_cs");
}