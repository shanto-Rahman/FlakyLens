@Test public void getBrokerUrlWithInMemorySetToFalse(){
assertEquals(DEFAULT_NETWORK_BROKER_URL,new ActiveMQConnectionFactoryFactory(this.properties).determineBrokerUrl());
}