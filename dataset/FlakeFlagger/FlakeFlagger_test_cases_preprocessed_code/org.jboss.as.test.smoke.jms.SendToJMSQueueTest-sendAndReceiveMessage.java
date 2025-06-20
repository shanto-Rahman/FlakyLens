@Test public void sendAndReceiveMessage() throws Exception {
Thread.sleep(2000);
if (session != null) {
}
if (connection != null) {
}
Assert.assertTrue(receivedMessage instanceof TextMessage);
Assert.assertTrue(((TextMessage)receivedMessage).getText().equals(MESSAGE_TEXT));
}