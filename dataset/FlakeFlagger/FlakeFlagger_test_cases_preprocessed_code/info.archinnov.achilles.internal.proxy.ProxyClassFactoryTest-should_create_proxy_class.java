@Test public void should_create_proxy_class() throws Exception {
assertThat(CompleteBean.class.isAssignableFrom(proxyClass)).isTrue();
assertThat(Factory.class.isAssignableFrom(proxyClass)).isTrue();
}