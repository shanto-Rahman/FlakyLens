@Test public void testMetricsIsSecure() throws Exception {
assertEquals(HttpStatus.UNAUTHORIZED,entity.getStatusCode());
}