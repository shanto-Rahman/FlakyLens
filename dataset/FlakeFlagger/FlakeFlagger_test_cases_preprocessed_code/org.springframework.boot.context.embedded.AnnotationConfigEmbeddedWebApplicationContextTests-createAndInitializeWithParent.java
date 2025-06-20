@Test public void createAndInitializeWithParent() throws Exception {
assertNotNull(this.context.getBean(ServletContextAwareConfiguration.class).getServletContext());
}