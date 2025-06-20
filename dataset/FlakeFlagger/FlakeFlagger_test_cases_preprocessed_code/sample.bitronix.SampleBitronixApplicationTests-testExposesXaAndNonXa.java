@Test public void testExposesXaAndNonXa() throws Exception {
assertThat(jmsConnectionFactory,sameInstance(xaJmsConnectionFactory));
assertThat(jmsConnectionFactory,instanceOf(PoolingConnectionFactory.class));
assertThat(nonXaJmsConnectionFactory,not(instanceOf(PoolingConnectionFactory.class)));
}