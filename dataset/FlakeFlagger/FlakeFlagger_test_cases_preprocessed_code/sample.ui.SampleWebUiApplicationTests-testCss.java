@Test public void testCss() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertTrue("Wrong body:\n" + entity.getBody(),entity.getBody().contains("body"));
}