@Test public void testLruCacheFactory() throws Exception {
assertThat(cache instanceof LruCache,is(true));
}