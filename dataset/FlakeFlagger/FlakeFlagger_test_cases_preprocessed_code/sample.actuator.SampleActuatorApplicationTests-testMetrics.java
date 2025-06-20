@Test public void testMetrics() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertTrue("Wrong body: " + body,body.containsKey("counter.status.200.root"));
}