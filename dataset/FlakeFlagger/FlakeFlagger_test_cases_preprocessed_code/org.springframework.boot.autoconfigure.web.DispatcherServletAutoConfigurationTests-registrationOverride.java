@Test public void registrationOverride() throws Exception {
assertEquals("[/foo]",registration.getUrlMappings().toString());
assertEquals("customDispatcher",registration.getServletName());
assertEquals(0,this.context.getBeanNamesForType(DispatcherServlet.class).length);
}