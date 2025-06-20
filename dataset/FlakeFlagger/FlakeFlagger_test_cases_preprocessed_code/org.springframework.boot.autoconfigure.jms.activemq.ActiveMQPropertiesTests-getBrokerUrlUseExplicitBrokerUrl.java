@Test public void getBrokerUrlUseExplicitBrokerUrl(){
assertEquals("vm://foo-bar",new ActiveMQConnectionFactoryFactory(this.properties).determineBrokerUrl());
}