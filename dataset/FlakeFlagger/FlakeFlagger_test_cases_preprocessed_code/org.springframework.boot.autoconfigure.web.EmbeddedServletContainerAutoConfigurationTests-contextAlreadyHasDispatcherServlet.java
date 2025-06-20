@Test public void contextAlreadyHasDispatcherServlet() throws Exception {
assertEquals(2,this.context.getBeanNamesForType(DispatcherServlet.class).length);
}