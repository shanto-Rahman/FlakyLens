@Test public void testBackgroundEvictionThread() throws Exception {
  long maxSize=100000;
  int numBlocks=9;
  long blockSize=calculateBlockSizeDefault(maxSize,numBlocks);
  assertTrue("calculateBlockSize appears broken.",blockSize * numBlocks <= maxSize);
  LruAdaptiveBlockCache cache=new LruAdaptiveBlockCache(maxSize,blockSize);
  EvictionThread evictionThread=cache.getEvictionThread();
  assertNotNull(evictionThread);
  CachedItem[] blocks=generateFixedBlocks(numBlocks + 1,blockSize,"block");
  while (!evictionThread.isEnteringRun()) {
    Thread.sleep(1);
  }
  for (  CachedItem block : blocks) {
    cache.cacheBlock(block.cacheKey,block);
  }
  int n=0;
  while (cache.getStats().getEvictionCount() == 0) {
    Thread.sleep(200);
    assertTrue("Eviction never happened.",n++ < 20);
  }
  n=0;
  for (long prevCnt=0, curCnt=cache.getBlockCount(); prevCnt != curCnt; prevCnt=curCnt, curCnt=cache.getBlockCount()) {
    Thread.sleep(200);
    assertTrue("Cache never stabilized.",n++ < 20);
  }
  long evictionCount=cache.getStats().getEvictionCount();
  assertTrue(evictionCount >= 1);
  System.out.println("Background Evictions run: " + evictionCount);
}
