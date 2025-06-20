@Test public void testLruCache() throws IOException {
Assert.assertNotNull(cache.get(key1));
Assert.assertNull(cache.get(key2));
}