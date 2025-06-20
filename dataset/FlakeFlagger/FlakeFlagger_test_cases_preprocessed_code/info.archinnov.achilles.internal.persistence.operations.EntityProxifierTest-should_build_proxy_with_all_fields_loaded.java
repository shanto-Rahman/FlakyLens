@Test public void should_build_proxy_with_all_fields_loaded() throws Exception {
assertThat(proxy).isNotNull();
assertThat(proxy).isInstanceOf(Factory.class);
assertThat(factory.getCallbacks()).hasSize(1);
assertThat(factory.getCallback(0)).isInstanceOf(EntityInterceptor.class);
}