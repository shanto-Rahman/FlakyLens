@Test public void tomcatProperties() throws Exception {
containerFactory=mock(TomcatEmbeddedServletContainerFactory.class);//RW
assertNotNull(server);
assertEquals(new File("target/foo"),server.getTomcat().getBasedir());//RO
verify(containerFactory).setPort(9000);//RW
}