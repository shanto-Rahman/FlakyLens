@Test public void testShutdown() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertTrue("Wrong body: " + body,((String)body.get("message")).contains("Shutting down"));
}