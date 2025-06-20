@Test public void registrationProperties() throws Exception {
assertNotNull(this.context.getBean(DispatcherServlet.class));
assertEquals("[/]",registration.getUrlMappings().toString());
}