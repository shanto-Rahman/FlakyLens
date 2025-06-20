@Test @SuppressWarnings("deprecation") public void warnsDefaultCredentialsWithTransport(){
LogRecord message=handler.getRecord();//IT
assertTrue(message.getMessage().contains("You are attempting to"));
}