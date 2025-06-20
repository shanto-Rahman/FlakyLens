@Test public void should_reuse_created_proxy_class_from_cache() throws Exception {
assertThat(proxyClass1 == proxyClass2).isTrue();
}