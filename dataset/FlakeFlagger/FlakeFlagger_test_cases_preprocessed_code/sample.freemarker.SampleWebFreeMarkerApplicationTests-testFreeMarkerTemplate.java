@Test public void testFreeMarkerTemplate() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertTrue("Wrong body:\n" + entity.getBody(),entity.getBody().contains("Hello, Andy"));
}