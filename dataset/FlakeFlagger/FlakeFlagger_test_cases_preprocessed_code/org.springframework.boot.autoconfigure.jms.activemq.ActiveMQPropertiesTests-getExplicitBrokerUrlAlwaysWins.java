@Test public void getExplicitBrokerUrlAlwaysWins(){
assertEquals("vm://foo-bar",new ActiveMQConnectionFactoryFactory(this.properties).determineBrokerUrl());
}