@Test public void testBackgroundEvictionThread() throws Exception {
assertTrue("calculateBlockSize appears broken.",blockSize * numBlocks <= maxSize);
assertNotNull(evictionThread);
Thread.sleep(1);
Thread.sleep(200);
assertTrue("Eviction never happened.",n++ < 20);
Thread.sleep(200);
assertTrue("Cache never stabilized.",n++ < 20);
assertTrue(evictionCount >= 1);
}