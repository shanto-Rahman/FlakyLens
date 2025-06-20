@Test public void testDestroyAll() throws Exception {
assertEquals(2,cache.cache.size());
assertTrue(config.isDestroyMethodRun());
assertTrue(configCopy.isDestroyMethodRun());
assertEquals(0,cache.cache.size());
}