@Test public void testJmsTemplatePostProcessedSoThatPubSubIsTrue(){
assertTrue(jmsTemplate.isPubSubDomain());
}