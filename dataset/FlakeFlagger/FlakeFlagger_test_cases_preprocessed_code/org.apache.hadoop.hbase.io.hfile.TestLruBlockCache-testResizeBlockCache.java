public void testResizeBlockCache() throws Exception {
assertEquals(0,cache.getEvictionCount());
assertEquals(1,cache.getEvictionCount());
assertEquals(15,cache.getEvictedCount());
assertEquals(null,cache.getBlock(singleBlocks[i].blockName));
assertEquals(null,cache.getBlock(multiBlocks[i].blockName));
assertEquals(null,cache.getBlock(memoryBlocks[i].blockName));
assertEquals(singleBlocks[i].buf,cache.getBlock(singleBlocks[i].blockName));
assertEquals(multiBlocks[i].buf,cache.getBlock(multiBlocks[i].blockName));
assertEquals(memoryBlocks[i].buf,cache.getBlock(memoryBlocks[i].blockName));
}