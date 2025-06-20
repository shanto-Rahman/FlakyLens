@Test public void testLogin() throws Exception {
assertEquals(HttpStatus.FOUND,entity.getStatusCode());
assertTrue("Wrong location:\n" + entity.getHeaders(),entity.getHeaders().getLocation().toString().endsWith(port + "/"));
assertNotNull("Missing cookie:\n" + entity.getHeaders(),entity.getHeaders().get("Set-Cookie"));
}