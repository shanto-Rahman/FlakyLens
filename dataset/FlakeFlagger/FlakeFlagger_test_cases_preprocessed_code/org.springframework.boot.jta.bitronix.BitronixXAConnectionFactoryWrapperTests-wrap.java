@Test public void wrap(){
assertThat(wrapped,instanceOf(PoolingConnectionFactoryBean.class));
assertThat(((PoolingConnectionFactoryBean)wrapped).getConnectionFactory(),sameInstance(connectionFactory));
}