@Test public void testHome() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertEquals("Hello Phil",body.get("message"));
assertFalse("Wrong headers: " + entity.getHeaders(),entity.getHeaders().containsKey("Set-Cookie"));
}