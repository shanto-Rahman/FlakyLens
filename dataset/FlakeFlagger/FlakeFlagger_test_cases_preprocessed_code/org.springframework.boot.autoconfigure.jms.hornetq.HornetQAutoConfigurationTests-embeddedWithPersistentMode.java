@Test public void embeddedWithPersistentMode() throws IOException, JMSException {
assertNotNull("No message on persistent queue",message);
assertEquals("Invalid message received on queue",msgId,((TextMessage)message).getText());
}