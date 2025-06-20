@Test public void testHealth() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertTrue("Wrong body: " + entity.getBody(),entity.getBody().contains("\"status\":\"UP\""));
}