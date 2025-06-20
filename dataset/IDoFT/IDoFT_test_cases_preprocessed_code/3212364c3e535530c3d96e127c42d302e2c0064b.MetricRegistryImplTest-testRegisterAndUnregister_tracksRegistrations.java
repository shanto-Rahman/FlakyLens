@Test public void testRegisterAndUnregister_tracksRegistrations(){
assertThat(MetricRegistryImpl.getDefault().getRegisteredMetrics()).isEmpty();
assertThat(MetricRegistryImpl.getDefault().getRegisteredMetrics()).containsExactly(metric);
assertThat(MetricRegistryImpl.getDefault().getRegisteredMetrics()).isEmpty();
}