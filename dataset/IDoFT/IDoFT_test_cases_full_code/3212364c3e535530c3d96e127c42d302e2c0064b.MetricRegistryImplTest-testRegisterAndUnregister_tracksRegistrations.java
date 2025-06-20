@Test public void testRegisterAndUnregister_tracksRegistrations(){
  assertThat(MetricRegistryImpl.getDefault().getRegisteredMetrics()).isEmpty();
  AbstractMetric<?> metric=mock(AbstractMetric.class);
  MetricRegistryImpl.getDefault().registerMetric("/test/metric",metric);
  assertThat(MetricRegistryImpl.getDefault().getRegisteredMetrics()).containsExactly(metric);
  MetricRegistryImpl.getDefault().unregisterMetric("/test/metric");
  assertThat(MetricRegistryImpl.getDefault().getRegisteredMetrics()).isEmpty();
}
