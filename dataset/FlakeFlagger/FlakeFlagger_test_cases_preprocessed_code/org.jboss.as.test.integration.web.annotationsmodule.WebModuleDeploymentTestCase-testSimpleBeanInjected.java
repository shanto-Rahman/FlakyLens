@Test public void testSimpleBeanInjected() throws Exception {
assertEquals(200,statusLine.getStatusCode());
Assert.assertEquals(ModuleServlet.MODULE_SERVLET,result);
}