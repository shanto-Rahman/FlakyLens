public void testCacheEvictionSimple() throws Exception {
expectedCacheSize+=block.heapSize();//IT
assertEquals(1,cache.getEvictionCount());
assertTrue(expectedCacheSize > (maxSize * LruBlockCache.DEFAULT_ACCEPTABLE_FACTOR));
assertTrue(cache.heapSize() < maxSize);
assertTrue(cache.heapSize() < (maxSize * LruBlockCache.DEFAULT_ACCEPTABLE_FACTOR));
assertTrue(cache.getBlock(blocks[0].blockName) == null);
assertTrue(cache.getBlock(blocks[1].blockName) == null);
assertEquals(cache.getBlock(blocks[i].blockName),blocks[i].buf);
}