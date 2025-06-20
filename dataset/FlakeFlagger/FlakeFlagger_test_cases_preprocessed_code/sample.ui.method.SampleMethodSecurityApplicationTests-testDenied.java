@Test public void testDenied() throws Exception {
assertEquals(HttpStatus.FOUND,entity.getStatusCode());
assertEquals(HttpStatus.FORBIDDEN,page.getStatusCode());
assertTrue("Wrong body (message doesn't match):\n" + entity.getBody(),page.getBody().contains("Access denied"));
}