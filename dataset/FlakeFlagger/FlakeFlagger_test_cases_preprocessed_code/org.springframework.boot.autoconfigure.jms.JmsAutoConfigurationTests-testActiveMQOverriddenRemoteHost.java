@Test public void testActiveMQOverriddenRemoteHost(){
assertNotNull(jmsTemplate);
assertNotNull(connectionFactory);
assertEquals(jmsTemplate.getConnectionFactory(),connectionFactory);
assertEquals("tcp://remote-host:10000",((ActiveMQConnectionFactory)jmsTemplate.getConnectionFactory()).getBrokerURL());
}