@Test public void testActiveMQOverriddenPoolAndStandalone(){
assertNotNull(jmsTemplate);
assertNotNull(pool);
assertEquals(jmsTemplate.getConnectionFactory(),pool);
assertEquals(ACTIVEMQ_NETWORK_URL,factory.getBrokerURL());
}