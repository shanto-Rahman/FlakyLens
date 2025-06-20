@Test public void testThreadLocalCacheFactory() throws Exception {
assertThat(cache instanceof ThreadLocalCache,is(true));
}