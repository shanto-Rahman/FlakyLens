@Test public void testDestroy() throws Exception {
assertEquals(2,cache.cache.size());
assertTrue(config.isDestroyMethodRun());
assertEquals(1,cache.cache.size());
assertTrue(configCopy.isDestroyMethodRun());
assertEquals(0,cache.cache.size());
}