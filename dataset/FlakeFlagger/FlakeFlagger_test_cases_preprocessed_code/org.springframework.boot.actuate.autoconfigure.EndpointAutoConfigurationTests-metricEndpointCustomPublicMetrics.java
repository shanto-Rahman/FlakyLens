@Test public void metricEndpointCustomPublicMetrics(){
assertTrue(metrics.containsKey("foo"));
assertTrue(metrics.containsKey("mem"));
assertTrue(metrics.containsKey("heap.used"));
}