@Test public void hasASetOfNames() throws Exception {
assertThat(SharedMetricRegistries.names()).containsOnly("one");
}