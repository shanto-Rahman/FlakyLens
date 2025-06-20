@Test public void metricEndpointsHasSystemMetricsByDefault(){
assertTrue(metrics.containsKey("mem"));
assertTrue(metrics.containsKey("heap.used"));
}