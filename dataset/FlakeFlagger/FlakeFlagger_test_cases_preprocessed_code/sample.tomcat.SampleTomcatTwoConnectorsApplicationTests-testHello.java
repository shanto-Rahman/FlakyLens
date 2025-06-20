@Test public void testHello() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertEquals("hello",entity.getBody());
assertEquals(HttpStatus.OK,httpsEntity.getStatusCode());
assertEquals("hello",httpsEntity.getBody());
}