@Test public void testLruCacheFactory() throws Exception {
assertThat(cache instanceof ExpiringCache,is(true));
}