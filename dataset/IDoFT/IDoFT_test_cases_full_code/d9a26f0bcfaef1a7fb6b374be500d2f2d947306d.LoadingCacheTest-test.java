@Test public void test() throws Exception {
  cache=LinkedHashMapCacheBuilder.createLinkedHashMapCacheBuilder().buildCache();
  cache=new LoadingCache<>(cache);
  baseTest();
  loadingCacheTest(cache,0);
  errorTest();
}
