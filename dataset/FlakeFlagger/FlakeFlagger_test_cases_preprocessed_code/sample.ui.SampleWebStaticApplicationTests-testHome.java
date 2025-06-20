@Test public void testHome() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertTrue("Wrong body (title doesn't match):\n" + entity.getBody(),entity.getBody().contains("<title>Static"));
}