@Test public void testHtmlErrorPage() throws Exception {
assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,entity.getStatusCode());
assertNotNull("Body was null",body);
assertTrue("Wrong body: " + body,body.contains("This application has no explicit mapping for /error"));
}