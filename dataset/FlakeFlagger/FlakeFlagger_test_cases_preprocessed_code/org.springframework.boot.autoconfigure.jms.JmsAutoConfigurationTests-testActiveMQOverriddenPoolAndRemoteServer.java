@Test public void testActiveMQOverriddenPoolAndRemoteServer(){
assertNotNull(jmsTemplate);
assertNotNull(pool);
assertEquals(jmsTemplate.getConnectionFactory(),pool);
assertEquals("tcp://remote-host:10000",factory.getBrokerURL());
}