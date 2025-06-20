@Test public void testVelocityTemplate() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertTrue("Wrong body:\n" + entity.getBody(),entity.getBody().contains("Hello, Andy"));
}