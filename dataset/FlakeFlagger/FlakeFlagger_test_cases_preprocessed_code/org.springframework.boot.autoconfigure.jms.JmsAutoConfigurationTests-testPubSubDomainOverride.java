@Test public void testPubSubDomainOverride(){
assertNotNull(jmsTemplate);
assertFalse(jmsTemplate.isPubSubDomain());
assertNotNull(connectionFactory);
assertEquals(jmsTemplate.getConnectionFactory(),connectionFactory);
}