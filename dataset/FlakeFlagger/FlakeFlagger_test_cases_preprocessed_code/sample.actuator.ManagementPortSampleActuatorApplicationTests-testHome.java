@Test public void testHome() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertEquals("Hello Phil",body.get("message"));
}