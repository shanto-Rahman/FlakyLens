@Test public void createAndInitializeCyclic() throws Exception {
assertNull(this.context.getBean(ServletContextAwareEmbeddedConfiguration.class).getServletContext());
}