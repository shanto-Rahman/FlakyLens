@Test public void customizeTomcatWithCustomizer() throws Exception {
containerFactory=mock(TomcatEmbeddedServletContainerFactory.class);//RW
assertNotNull(server);
verify(containerFactory).setPort(3000);//RW
}