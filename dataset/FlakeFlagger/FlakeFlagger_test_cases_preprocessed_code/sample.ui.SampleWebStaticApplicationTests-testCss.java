@Test public void testCss() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertTrue("Wrong body:\n" + entity.getBody(),entity.getBody().contains("body"));
assertEquals("Wrong content type:\n" + entity.getHeaders().getContentType(),MediaType.valueOf("text/css"),entity.getHeaders().getContentType());
}