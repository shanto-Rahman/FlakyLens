@Test public void testLogin() throws Exception {
assertEquals(HttpStatus.FOUND,entity.getStatusCode());
assertEquals("http://localhost:" + this.port + "/",entity.getHeaders().getLocation().toString());
}