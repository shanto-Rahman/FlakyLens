@Test public void testHomeIsSecure() throws Exception {
assertEquals(HttpStatus.UNAUTHORIZED,entity.getStatusCode());
assertEquals("Wrong body: " + body,"Unauthorized",body.get("error"));
assertFalse("Wrong headers: " + entity.getHeaders(),entity.getHeaders().containsKey("Set-Cookie"));
}