@Test public void should_remove_counter() throws Exception {
assertThat(row.getLong("counter_value")).isEqualTo(version);
Thread.sleep(1000);
assertThat(row).isNull();
}