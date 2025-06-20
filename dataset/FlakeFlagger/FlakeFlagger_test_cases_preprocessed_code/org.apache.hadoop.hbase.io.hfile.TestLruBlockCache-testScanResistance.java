public void testScanResistance() throws Exception {
assertEquals(1,cache.getEvictionCount());
assertEquals(4,cache.getEvictedCount());
assertEquals(null,cache.getBlock(singleBlocks[0].blockName));
assertEquals(null,cache.getBlock(singleBlocks[1].blockName));
assertEquals(null,cache.getBlock(multiBlocks[0].blockName));
assertEquals(null,cache.getBlock(multiBlocks[1].blockName));
assertEquals(4,cache.getEvictionCount());
assertEquals(16,cache.getEvictedCount());
assertEquals(7,cache.size());
}