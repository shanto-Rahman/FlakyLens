@Test public void testCustomContextPath() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertTrue("Wrong body: " + entity.getBody(),entity.getBody().contains("\"status\":\"UP\""));
}