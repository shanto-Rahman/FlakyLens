@Test public void customizeWithContainerFactory() throws Exception {
containerFactory=this.context.getBean(AbstractEmbeddedServletContainerFactory.class);//RW
assertNotNull(server);
assertEquals(3000,containerFactory.getPort());//RW
}