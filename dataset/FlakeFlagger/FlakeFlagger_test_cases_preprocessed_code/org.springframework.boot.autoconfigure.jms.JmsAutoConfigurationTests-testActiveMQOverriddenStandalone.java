@Test public void testActiveMQOverriddenStandalone(){
assertNotNull(jmsTemplate);
assertNotNull(connectionFactory);
assertEquals(jmsTemplate.getConnectionFactory(),connectionFactory);
assertEquals(ACTIVEMQ_NETWORK_URL,((ActiveMQConnectionFactory)jmsTemplate.getConnectionFactory()).getBrokerURL());
}