@Test public void testHomeIsSecure() throws Exception {
assertEquals(HttpStatus.UNAUTHORIZED,entity.getStatusCode());
}