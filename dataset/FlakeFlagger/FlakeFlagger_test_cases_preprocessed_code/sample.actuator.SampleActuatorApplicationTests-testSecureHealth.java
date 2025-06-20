@Test public void testSecureHealth() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertTrue("Wrong body: " + entity.getBody(),entity.getBody().contains("\"hello\":1"));
}