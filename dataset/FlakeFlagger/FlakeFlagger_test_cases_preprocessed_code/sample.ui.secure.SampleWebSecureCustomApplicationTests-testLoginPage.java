@Test public void testLoginPage() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertTrue("Wrong content:\n" + entity.getBody(),entity.getBody().contains("_csrf"));
}