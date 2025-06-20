public void testCacheSimple() throws Exception {
assertTrue(cache.getBlock(block.blockName) == null);
expectedCacheSize+=block.heapSize();//IT
assertEquals(expectedCacheSize,cache.heapSize());
assertTrue(buf != null);
assertEquals(buf.capacity(),block.buf.capacity());
assertTrue("Cache should not allow re-caching a block",false);
assertEquals(expectedCacheSize,cache.heapSize());
assertTrue(buf != null);
assertEquals(buf.capacity(),block.buf.capacity());
assertEquals(0,cache.getEvictionCount());
}