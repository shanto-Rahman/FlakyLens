@Test public void singleUploadProgressTrackerFactory_resetProgressTracker(){
  final long totalBytes=ThreadLocalRandom.current().nextLong(MAX_BLOCK_SIZE);
  final ProgressReporter mockProgressReporter=mock(ProgressReporter.class);
  final ProgressTrackerFactory progressTrackerFactory=ProgressTrackerFactory.createSingleUploadProgressTrackerFactory(mockProgressReporter,totalBytes);
  final ProgressTracker progressTracker=progressTrackerFactory.getProgressTracker();
  progressTracker.reset();
  progressTracker.onBytesRead(READ_CHUNK_SIZE);
  progressTracker.onBytesRead(READ_CHUNK_SIZE);
  progressTracker.reset();
  progressTracker.onBytesRead(READ_CHUNK_SIZE);
  progressTracker.onBytesRead(READ_CHUNK_SIZE);
  progressTracker.onBytesRead(READ_CHUNK_SIZE);
  progressTracker.onBytesRead(READ_CHUNK_SIZE);
  progressTracker.reset();
  progressTracker.reset();
  ArgumentCaptor<Long> bytesReadArgumentCaptor=ArgumentCaptor.forClass(Long.class);
  verify(mockProgressReporter,times(6)).onProgress(bytesReadArgumentCaptor.capture(),eq(totalBytes));
  List<Long> expectedBytesReadList=Arrays.asList(READ_CHUNK_SIZE,2 * READ_CHUNK_SIZE,READ_CHUNK_SIZE,2 * READ_CHUNK_SIZE,3 * READ_CHUNK_SIZE,4 * READ_CHUNK_SIZE);
  assertEquals(expectedBytesReadList,bytesReadArgumentCaptor.getAllValues());
}
