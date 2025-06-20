@Test public void testActiveMQOverriddenPool(){
assertNotNull(jmsTemplate);
assertNotNull(pool);
assertEquals(jmsTemplate.getConnectionFactory(),pool);
assertEquals(ACTIVEMQ_EMBEDDED_URL,factory.getBrokerURL());
}