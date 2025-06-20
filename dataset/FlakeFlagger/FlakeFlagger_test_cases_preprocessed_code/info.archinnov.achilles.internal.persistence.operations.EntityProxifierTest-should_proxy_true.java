@Test public void should_proxy_true() throws Exception {
assertThat(proxifier.isProxy(proxy)).isTrue();
}