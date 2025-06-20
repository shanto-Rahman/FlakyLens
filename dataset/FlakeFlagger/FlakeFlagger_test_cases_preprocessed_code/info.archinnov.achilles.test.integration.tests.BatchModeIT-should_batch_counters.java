@Test public void should_batch_counters() throws Exception {
assertThat(result).isNull();
assertThat(result).isNull();
assertThat(row.getString("label")).isEqualTo("label");
assertThat(result.get("counter_value")).isEqualTo(10L);
}