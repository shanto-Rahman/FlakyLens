@Test public void removesRegistries() throws Exception {
  final MetricRegistry one=SharedMetricRegistries.getOrCreate("one");
  SharedMetricRegistries.remove("one");
  assertThat(SharedMetricRegistries.names()).isEmpty();
  final MetricRegistry two=SharedMetricRegistries.getOrCreate("one");
  assertThat(two).isNotSameAs(one);
}
