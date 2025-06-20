@Test public void testRetryCacheEntryCount(){
retryCache.refreshEntry(entry);//RW
retryCache.close();//RW
}