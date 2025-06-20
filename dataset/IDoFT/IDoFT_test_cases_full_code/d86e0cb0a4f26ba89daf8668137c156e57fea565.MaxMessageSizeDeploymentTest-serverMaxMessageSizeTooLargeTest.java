@Test public void serverMaxMessageSizeTooLargeTest() throws DeploymentException, InterruptedException, IOException {
  Map<String,Object> serverProperties=getServerProperties();
  serverProperties.put(TyrusWebSocketEngine.INCOMING_BUFFER_SIZE,1);
  final AtomicBoolean warningLogged=new AtomicBoolean(false);
  LoggerHandler handler=new LoggerHandler(){
    @Override public void publish(    LogRecord record){
      String expectedWarningMessage=LocalizationMessages.ENDPOINT_MAX_MESSAGE_SIZE_TOO_LONG(2,LargeMaxMessageSizeServerEndpoint.class.getMethods()[0].getName(),LargeMaxMessageSizeServerEndpoint.class.getName(),1);
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
  Server server=null;
  try {
    server=startServer(LargeMaxMessageSizeServerEndpoint.class);
  }
  finally {
    stopServer(server);
  }
  assertTrue(warningLogged.get());
  logger.removeHandler(handler);
}
