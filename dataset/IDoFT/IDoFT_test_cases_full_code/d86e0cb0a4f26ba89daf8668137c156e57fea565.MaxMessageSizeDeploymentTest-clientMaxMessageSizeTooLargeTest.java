@Test public void clientMaxMessageSizeTooLargeTest() throws DeploymentException {
  Server server=startServer(DummyServerEndpoint.class);
  try {
    ClientManager client=createClient();
    Map<String,Object> properties=client.getProperties();
    properties.put(ClientProperties.INCOMING_BUFFER_SIZE,1);
    final AtomicBoolean warningLogged=new AtomicBoolean(false);
    LoggerHandler handler=new LoggerHandler(){
      @Override public void publish(      LogRecord record){
        String expectedWarningMessage=LocalizationMessages.ENDPOINT_MAX_MESSAGE_SIZE_TOO_LONG(2,LargeMaxMessageSizeClientEndpoint.class.getMethods()[0].getName(),LargeMaxMessageSizeClientEndpoint.class.getName(),1);
        System.out.println("Expected message: " + expectedWarningMessage);
        System.out.println("Logged message: " + record.getMessage());
        if (expectedWarningMessage.equals(record.getMessage())) {
          warningLogged.set(true);
        }
      }
    }
;
    logger.setLevel(Level.CONFIG);
    logger.addHandler(handler);
    client.connectToServer(LargeMaxMessageSizeClientEndpoint.class,getURI(DummyServerEndpoint.class,"ws"));
    assertTrue(warningLogged.get());
    logger.removeHandler(handler);
  }
 catch (  IOException e) {
    e.printStackTrace();
    fail();
  }
 finally {
    stopServer(server);
  }
}
