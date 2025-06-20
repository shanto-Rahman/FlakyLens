@Test public void testErrorPage() throws Exception {
assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,entity.getStatusCode());
assertNotNull(body);
assertTrue("Wrong body: " + body,body.contains("\"error\":"));
}