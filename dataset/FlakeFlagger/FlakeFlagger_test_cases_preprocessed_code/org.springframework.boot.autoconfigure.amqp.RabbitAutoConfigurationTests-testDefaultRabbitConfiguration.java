@Test public void testDefaultRabbitConfiguration(){
assertEquals(connectionFactory,rabbitTemplate.getConnectionFactory());
assertEquals(rabbitTemplate,messagingTemplate.getRabbitTemplate());
assertNotNull(amqpAdmin);
assertEquals("localhost",connectionFactory.getHost());
assertTrue("Listener container factory should be created by default",this.context.containsBean("rabbitListenerContainerFactory"));
}