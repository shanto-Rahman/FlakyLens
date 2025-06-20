@Test public void should_return_cql_functions_for_native_query() throws Exception {
assertThat(result.get("now()")).isNotNull().isInstanceOf(UUID.class);
assertThat(result.get("dateOf(date)")).isNotNull().isInstanceOf(Date.class);
assertThat(result.get("unixTimestampOf(date)")).isNotNull().isInstanceOf(Long.class);
}