public void testCacheEvictionTwoPriorities() throws Exception {
expectedCacheSize+=block.heapSize();//IT
assertEquals(cache.getBlock(block.blockName),block.buf);
expectedCacheSize+=block.heapSize();//IT
assertEquals(cache.getEvictionCount(),1);
assertEquals(cache.getEvictedCount(),2);
assertTrue(expectedCacheSize > (maxSize * LruBlockCache.DEFAULT_ACCEPTABLE_FACTOR));
assertTrue(cache.heapSize() <= maxSize);
assertTrue(cache.heapSize() <= (maxSize * LruBlockCache.DEFAULT_ACCEPTABLE_FACTOR));
assertTrue(cache.getBlock(singleBlocks[0].blockName) == null);
assertTrue(cache.getBlock(multiBlocks[0].blockName) == null);
assertEquals(cache.getBlock(singleBlocks[i].blockName),singleBlocks[i].buf);
assertEquals(cache.getBlock(multiBlocks[i].blockName),multiBlocks[i].buf);
}