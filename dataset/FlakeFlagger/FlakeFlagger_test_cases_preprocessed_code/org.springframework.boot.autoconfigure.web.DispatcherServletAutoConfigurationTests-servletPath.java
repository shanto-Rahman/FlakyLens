@Test public void servletPath() throws Exception {
assertNotNull(this.context.getBean(DispatcherServlet.class));
assertEquals("[/spring/*]",registration.getUrlMappings().toString());
assertNull(registration.getMultipartConfig());
}