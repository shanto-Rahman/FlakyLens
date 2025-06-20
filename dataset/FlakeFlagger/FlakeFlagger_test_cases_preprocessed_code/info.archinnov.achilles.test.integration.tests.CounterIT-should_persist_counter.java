@Test public void should_persist_counter() throws Exception {
assertThat(row.getLong("counter_value")).isEqualTo(2L);
}