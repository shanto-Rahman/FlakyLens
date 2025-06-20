@Test public void backOffWithCustomConfiguration(){
assertNotNull(this.context.getBean(RepositoryRestMvcConfiguration.class));
assertEquals("Custom base URI should not have been set",URI.create(""),bean.getBaseUri());
}