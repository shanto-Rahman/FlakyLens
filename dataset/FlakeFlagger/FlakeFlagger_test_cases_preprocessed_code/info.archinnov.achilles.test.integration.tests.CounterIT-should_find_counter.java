@Test public void should_find_counter() throws Exception {
assertThat(row.getLong("counter_value")).isEqualTo(version);
}