@Test public void should_return_rows_for_native_query_with_bound_values() throws Exception {
assertThat(actual).hasSize(1);
assertThat(row.get("name")).isEqualTo("DuyHai");
}