@Test @SuppressWarnings("deprecation") public void warnsDefaultCredentialsWithTransport(){
  Logger logger=Logger.getLogger(AppEngineCredentials.class.getName());
  LogHandler handler=new LogHandler();
  logger.addHandler(handler);
  try {
    Credentials unused=AppEngineCredentials.getApplicationDefault(new HttpTransportFactory(){
      @Override public HttpTransport create(){
        return null;
      }
    }
);
  }
 catch (  IOException ex) {
  }
  LogRecord message=handler.getRecord();
  assertTrue(message.getMessage().contains("You are attempting to"));
}
