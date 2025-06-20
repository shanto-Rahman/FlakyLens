@Test public void wrap(){
assertThat(wrapped,instanceOf(AtomikosConnectionFactoryBean.class));
assertThat(((AtomikosConnectionFactoryBean)wrapped).getXaConnectionFactory(),sameInstance(connectionFactory));
}