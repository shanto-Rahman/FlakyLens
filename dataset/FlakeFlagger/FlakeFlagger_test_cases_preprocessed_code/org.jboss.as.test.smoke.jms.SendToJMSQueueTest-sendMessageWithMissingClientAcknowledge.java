@Test public void sendMessageWithMissingClientAcknowledge() throws Exception {
if (senderSession != null) {
}
if (senderConnection != null) {
}
Thread.sleep(1000);
Assert.fail(e.getMessage());
if (consumerSession != null) {
}
if (consumerConnection != null) {
}
if (receivedMessage == null) {
Assert.fail("Message should have been re-delivered, but subsequent attempt to receive it returned null");
}
Assert.assertTrue("received a " + receivedMessage.getClass().getName() + " instead of a TextMessage",receivedMessage instanceof TextMessage);
Assert.assertEquals(((TextMessage)receivedMessage).getText(),"Hello world!");
Assert.assertTrue("Redelivered header should have been set to true",receivedMessage.getJMSRedelivered());
}