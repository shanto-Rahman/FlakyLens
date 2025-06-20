@Test public void singleUploadProgressTrackerFactory_resetProgressTracker(){
final long totalBytes=ThreadLocalRandom.current().nextLong(MAX_BLOCK_SIZE);
assertEquals(expectedBytesReadList,bytesReadArgumentCaptor.getAllValues());
}