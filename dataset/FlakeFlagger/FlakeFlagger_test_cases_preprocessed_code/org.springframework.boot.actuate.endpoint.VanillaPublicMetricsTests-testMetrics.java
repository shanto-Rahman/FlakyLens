@Test public void testMetrics() throws Exception {
assertTrue(results.containsKey("mem"));
assertTrue(results.containsKey("mem.free"));
assertThat(results.get("a").getValue().doubleValue(),equalTo(0.5));
}