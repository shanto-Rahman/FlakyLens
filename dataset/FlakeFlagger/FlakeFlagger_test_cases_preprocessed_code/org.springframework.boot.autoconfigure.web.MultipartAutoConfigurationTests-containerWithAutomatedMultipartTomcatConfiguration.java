@Test public void containerWithAutomatedMultipartTomcatConfiguration() throws Exception {
assertSame(this.context.getBean(DispatcherServlet.class).getMultipartResolver(),this.context.getBean(StandardServletMultipartResolver.class));
}