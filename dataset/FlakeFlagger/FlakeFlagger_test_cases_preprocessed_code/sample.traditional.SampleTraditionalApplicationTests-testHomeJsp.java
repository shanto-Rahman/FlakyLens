@Test public void testHomeJsp() throws Exception {
assertEquals(HttpStatus.OK,entity.getStatusCode());
assertTrue("Wrong body:\n" + body,body.contains("<html>"));
assertTrue("Wrong body:\n" + body,body.contains("<h1>Home</h1>"));
}