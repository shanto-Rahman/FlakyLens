@Test public void contextAlreadyHasNonServlet() throws Exception {
assertEquals(0,this.context.getBeanNamesForType(DispatcherServlet.class).length);
assertEquals(0,this.context.getBeanNamesForType(Servlet.class).length);
}