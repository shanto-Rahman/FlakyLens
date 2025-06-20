@Test public void should_set_counter_on_managed_entity() throws Exception {
assertThat(row.getLong("counter_value")).isEqualTo(2L);
}