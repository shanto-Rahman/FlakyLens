@Test public void should_not_load_clustered_counters_when_not_found() throws Exception {
assertThat(actual).isNull();
}