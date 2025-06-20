@Test public void testManagementProtected() throws Exception {
assertEquals(HttpStatus.UNAUTHORIZED,entity.getStatusCode());
}