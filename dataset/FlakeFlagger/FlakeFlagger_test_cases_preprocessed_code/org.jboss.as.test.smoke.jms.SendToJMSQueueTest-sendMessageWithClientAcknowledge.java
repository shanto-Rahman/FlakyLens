@Test public void sendMessageWithClientAcknowledge() throws Exception {
if (senderSession != null) {
}
if (senderConnection != null) {
}
if (consumerSession != null) {
}
if (consumerConnection != null) {
}
if (receivedMessage == null) {
Assert.fail("received null instead of a TextMessage");
}
Assert.assertTrue("received a " + receivedMessage.getClass().getName() + " instead of a TextMessage",receivedMessage instanceof TextMessage);
Assert.assertEquals("Hahaha!",((TextMessage)receivedMessage).getText());
if (receivedMessage2 != null) {
Assert.fail("redelivered=" + String.valueOf(receivedMessage2.getJMSRedelivered()) + ", text="+ ((TextMessage)receivedMessage).getText());
}
Assert.assertNull("Message should not have been re-delivered",receivedMessage2);
}