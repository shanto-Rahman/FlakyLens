@Test public void should_insert_with_insert_strategy_non_null_fields() throws Exception {
assertThat(row).isNotNull();
assertThat(row.getString("value")).isEqualTo("0 AM");
}