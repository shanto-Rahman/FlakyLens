@Test public void contextAlreadyHasDispatcherServletAndRegistration() throws Exception {
assertEquals(1,this.context.getBeanNamesForType(DispatcherServlet.class).length);
}