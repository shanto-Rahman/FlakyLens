@Test public void testDefaultRepositoryConfiguration() throws Exception {
assertNotNull(this.context.getBean(RepositoryRestMvcConfiguration.class));
}