@Test public void extendedExtensionTest() throws DeploymentException {
  EXTENDED_EXTENSION=new MyExtendedExtension();
  Server server=startServer(ExtendedExtensionApplicationConfig.class);
  final CountDownLatch messageLatch=new CountDownLatch(1);
  try {
    ArrayList<Extension> extensions=new ArrayList<Extension>();
    extensions.add(EXTENDED_EXTENSION);
    final ClientEndpointConfig clientConfiguration=ClientEndpointConfig.Builder.create().extensions(extensions).configurator(new LoggingClientEndpointConfigurator()).build();
    ClientManager client=createClient();
    final Session session=client.connectToServer(new Endpoint(){
      @Override public void onOpen(      Session session,      EndpointConfig config){
        session.addMessageHandler(new MessageHandler.Whole<String>(){
          @Override public void onMessage(          String message){
            System.out.println("client onMessage: " + message);
            messageLatch.countDown();
          }
        }
);
        try {
          session.getBasicRemote().sendText("Always pass on what you have learned.");
        }
 catch (        IOException e) {
          e.printStackTrace();
        }
      }
    }
,clientConfiguration,getURI("/extendedExtensionEndpoint"));
    assertEquals(1,session.getNegotiatedExtensions().size());
    final Extension extension=session.getNegotiatedExtensions().get(0);
    assertEquals(EXTENDED_EXTENSION,extension);
    assertTrue(messageLatch.await(1,TimeUnit.SECONDS));
    assertEquals(2,EXTENDED_EXTENSION.incomingCounter.get());
    assertEquals(2,EXTENDED_EXTENSION.outgoingCounter.get());
    assertNotNull(EXTENDED_EXTENSION.onExtensionNegotiation);
    assertNotNull(EXTENDED_EXTENSION.onHandshakeResponse);
    assertEquals(1,EXTENDED_EXTENSION.onHandshakeResponse.size());
    assertEquals("param1",EXTENDED_EXTENSION.onHandshakeResponse.get(0).getName());
    assertEquals("value1",EXTENDED_EXTENSION.onHandshakeResponse.get(0).getValue());
    assertEquals(EXTENDED_EXTENSION.getParameters().size(),EXTENDED_EXTENSION.onExtensionNegotiation.size());
    assertEquals(EXTENDED_EXTENSION.getParameters().get(0).getName(),EXTENDED_EXTENSION.onExtensionNegotiation.get(0).getName());
    assertEquals(EXTENDED_EXTENSION.getParameters().get(0).getValue(),EXTENDED_EXTENSION.onExtensionNegotiation.get(0).getValue());
  }
 catch (  Exception e) {
    e.printStackTrace();
    throw new RuntimeException(e.getMessage(),e);
  }
 finally {
    stopServer(server);
  }
}
