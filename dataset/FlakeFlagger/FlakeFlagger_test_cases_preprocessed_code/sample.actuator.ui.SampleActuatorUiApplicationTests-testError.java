@Test public void testError() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertTrue("Wrong body:\n" + entity.getBody(),entity.getBody().contains("<html>"));
assertTrue("Wrong body:\n" + entity.getBody(),entity.getBody().contains("<body>"));
assertTrue("Wrong body:\n" + entity.getBody(),entity.getBody().contains("Please contact the operator with the above information"));
}