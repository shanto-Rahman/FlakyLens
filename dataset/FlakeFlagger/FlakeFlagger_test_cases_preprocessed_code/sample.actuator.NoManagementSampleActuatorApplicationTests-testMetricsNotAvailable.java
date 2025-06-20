@Test public void testMetricsNotAvailable() throws Exception {
assertEquals(HttpStatus.NOT_FOUND,entity.getStatusCode());
}