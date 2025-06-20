@Test public void testConnectionFactoryBackOff(){
assertEquals("foobar",this.context.getBean(ActiveMQConnectionFactory.class).getBrokerURL());
}