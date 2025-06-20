@Test public void testJmsTemplateBackOffEverything(){
assertEquals(999,jmsTemplate.getPriority());
assertEquals("foobar",this.context.getBean(ActiveMQConnectionFactory.class).getBrokerURL());
assertEquals("fooBar",messagingTemplate.getDefaultDestinationName());
assertEquals(jmsTemplate,messagingTemplate.getJmsTemplate());
}