@Test public void richGaugePublicMetrics(){
assertNotNull(richGaugeReader);
assertNotNull(publicMetrics);
assertNotNull(metrics);
assertEquals(metrics.size(),6);
}