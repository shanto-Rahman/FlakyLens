@Test public void nativeConnectionFactory(){
assertEquals(jmsTemplate.getConnectionFactory(),connectionFactory);
}