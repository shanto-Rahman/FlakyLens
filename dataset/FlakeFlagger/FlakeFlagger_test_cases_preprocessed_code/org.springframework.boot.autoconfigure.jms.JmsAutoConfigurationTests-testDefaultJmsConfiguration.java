@Test public void testDefaultJmsConfiguration(){
assertEquals(jmsTemplate.getConnectionFactory(),connectionFactory);
assertEquals(jmsTemplate,messagingTemplate.getJmsTemplate());
assertEquals(ACTIVEMQ_EMBEDDED_URL,((ActiveMQConnectionFactory)jmsTemplate.getConnectionFactory()).getBrokerURL());
assertTrue("listener container factory should be created by default",this.context.containsBean("jmsListenerContainerFactory"));
}