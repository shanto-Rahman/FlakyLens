@Test public void removesRegistries() throws Exception {
assertThat(SharedMetricRegistries.names()).isEmpty();
assertThat(two).isNotSameAs(one);
}