@Test(expected=UnsatisfiedDependencyException.class) public void registrationOverrideWithAutowiredServlet() throws Exception {
assertEquals("[/foo]",registration.getUrlMappings().toString());
assertEquals("customDispatcher",registration.getServletName());
assertEquals(1,this.context.getBeanNamesForType(DispatcherServlet.class).length);
}