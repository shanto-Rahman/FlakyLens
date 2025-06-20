@Test public void containerWithAutomatedMultipartJettyConfiguration(){
assertSame(this.context.getBean(DispatcherServlet.class).getMultipartResolver(),this.context.getBean(StandardServletMultipartResolver.class));
}