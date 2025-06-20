@Test public void testHealth() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertEquals("{\"status\":\"UP\"}",entity.getBody());
}