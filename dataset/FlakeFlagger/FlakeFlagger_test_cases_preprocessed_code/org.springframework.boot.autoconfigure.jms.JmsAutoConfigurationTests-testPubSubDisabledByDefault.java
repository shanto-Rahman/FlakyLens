@Test public void testPubSubDisabledByDefault(){
assertFalse(jmsTemplate.isPubSubDomain());
}