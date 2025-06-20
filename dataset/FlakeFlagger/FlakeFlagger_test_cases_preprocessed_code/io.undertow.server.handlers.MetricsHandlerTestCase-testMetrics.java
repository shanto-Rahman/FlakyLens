@Test public void testMetrics() throws IOException, InterruptedException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("Hello",HttpClientUtils.readResponse(result));
latchHandler.await();//RW
latchHandler.reset();//RW
MetricsHandler.MetricResult metrics=metricsHandler.getMetrics();//RW
Assert.assertEquals(1,metrics.getTotalRequests());
Assert.assertTrue(metrics.getMaxRequestTime() > 0);
Assert.assertEquals(metrics.getMinRequestTime(),metrics.getMaxRequestTime());
Assert.assertEquals(metrics.getMaxRequestTime(),metrics.getTotalRequestTime());
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("Hello",HttpClientUtils.readResponse(result));
latchHandler.await();//RW
latchHandler.reset();//RW
metrics=metricsHandler.getMetrics();//RW
Assert.assertEquals(2,metrics.getTotalRequests());
}