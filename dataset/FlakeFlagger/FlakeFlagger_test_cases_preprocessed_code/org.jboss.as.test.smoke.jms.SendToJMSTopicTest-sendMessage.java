@Test public void sendMessage() throws Exception {
if (senderSession != null) {
}
if (senderConnection != null) {
}
Assert.fail(e.getMessage());
if (receivedMessage == null) {
Assert.fail("received null instead of a TextMessage");
}
if (consumerSession != null) {
}
if (consumerConnection != null) {
}
Assert.assertTrue("received a " + receivedMessage.getClass().getName() + " instead of a TextMessage",receivedMessage instanceof TextMessage);
Assert.assertEquals(((TextMessage)receivedMessage).getText(),"Hello world!");
}