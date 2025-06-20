@Test public void testErrorHandling() throws Exception {
  ServerWebSocketContainer builder=new ServerWebSocketContainer(TestClassIntrospector.INSTANCE,DefaultServer.getWorker(),DefaultServer.getBufferPool(),Collections.EMPTY_LIST,false,false);
  builder.addEndpoint(ServerEndpointConfig.Builder.create(ProgramaticErrorEndpoint.class,"/").configurator(new InstanceConfigurator(new ProgramaticErrorEndpoint())).build());
  deployServlet(builder);
  AnnotatedClientEndpoint c=new AnnotatedClientEndpoint();
  Session session=ContainerProvider.getWebSocketContainer().connectToServer(c,new URI("ws://" + DefaultServer.getHostAddress("default") + ":"+ DefaultServer.getHostPort("default")+ "/"));
  Assert.assertEquals("hi",ProgramaticErrorEndpoint.getMessage());
  session.getAsyncRemote().sendText("app-error");
  Assert.assertEquals("app-error",ProgramaticErrorEndpoint.getMessage());
  Assert.assertEquals("ERROR: java.lang.RuntimeException",ProgramaticErrorEndpoint.getMessage());
  Assert.assertTrue(c.isOpen());
  session.getBasicRemote().sendText("io-error");
  Assert.assertEquals("io-error",ProgramaticErrorEndpoint.getMessage());
  Assert.assertEquals("ERROR: java.lang.RuntimeException",ProgramaticErrorEndpoint.getMessage());
  Assert.assertTrue(c.isOpen());
  ((UndertowSession)session).forceClose();
  Assert.assertEquals("CLOSED",ProgramaticErrorEndpoint.getMessage());
}
