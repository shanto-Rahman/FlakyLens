@Test public void testWithCustomBaseUri() throws Exception {
assertNotNull(this.context.getBean(RepositoryRestMvcConfiguration.class));
assertEquals("Custom baseURI not set",expectedUri,bean.getBaseUri());
assertEquals("Custom baseUri has not been applied to BaseUri bean",expectedUri,baseUri.getUri());
}