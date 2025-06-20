/** 
 * Send a message on the source queue Consumes it on the target queue The test will pass since a JMS Bridge has been created to bridge the source destination to the target destination.
 */
@Test public void sendAndReceiveMessage() throws Exception {
assertNotNull("did not receive expected message",receivedMessage);
assertTrue(receivedMessage instanceof TextMessage);
assertEquals(text,((TextMessage)receivedMessage).getText());
assertNotNull("did not get header set by the JMS bridge",receivedMessage.getStringProperty(ActiveMQJMSConstants.AMQ_MESSAGING_BRIDGE_MESSAGE_ID_LIST));
if (session != null) {
}
if (connection != null) {
}
}