@Test public void brokerIsEmbeddedByDefault(){
assertThat(connectionFactory,instanceOf(ActiveMQConnectionFactory.class));
assertEquals("vm://localhost?broker.persistent=false",brokerUrl);
}