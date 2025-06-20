@Test public void hasASetOfNames() throws Exception {
  SharedMetricRegistries.getOrCreate("one");
  assertThat(SharedMetricRegistries.names()).containsOnly("one");
}
