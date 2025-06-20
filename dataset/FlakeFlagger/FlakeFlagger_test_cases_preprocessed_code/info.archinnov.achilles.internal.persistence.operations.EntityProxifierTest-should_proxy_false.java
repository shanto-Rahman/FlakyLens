@Test public void should_proxy_false() throws Exception {
assertThat(proxifier.isProxy(bean)).isFalse();
}