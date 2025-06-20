@Test public void testHome() throws Exception {
assertEquals(HttpStatus.FOUND,entity.getStatusCode());
assertTrue("Wrong location:\n" + entity.getHeaders(),entity.getHeaders().getLocation().toString().endsWith(port + "/login"));
}