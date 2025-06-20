@Test public void multipartUploadProgressTrackerFactory_simulateRealLifeScenario() throws InterruptedException {
  final long totalBytes=Long.MAX_VALUE;
  final ProgressReporter mockProgressReporter=mock(ProgressReporter.class);
  final ProgressTrackerFactory progressTrackerFactory=ProgressTrackerFactory.createMultiPartUploadProgressTrackerFactory(mockProgressReporter,totalBytes);
  final List<Long> expectedBytesReadList=Collections.synchronizedList(new ArrayList<Long>());
  final AtomicLong totalBytesRead=new AtomicLong();
  final int THREAD_POOL_SIZE=3;
  final int NUMBER_OF_CHUNKS=10;
  final int SIZE_OF_CHUNK=128 * 1024 * 1024;
  final ExecutorService executorService=Executors.newFixedThreadPool(THREAD_POOL_SIZE);
  for (int i=0; i < NUMBER_OF_CHUNKS; i++) {
    executorService.submit(new Runnable(){
      final ProgressTracker progressTracker=progressTrackerFactory.getProgressTracker();
      @Override public void run(){
        long expectedBytesRead=0;
        for (int i=0; i < SIZE_OF_CHUNK / READ_CHUNK_SIZE; i++) {
          int diceRoll=ThreadLocalRandom.current().nextInt();
synchronized (expectedBytesReadList) {
            if (diceRoll % 10 == 0) {
              progressTracker.reset();
              totalBytesRead.addAndGet(-1 * expectedBytesRead);
              expectedBytesRead=0;
            }
 else {
              progressTracker.onBytesRead(READ_CHUNK_SIZE);
              expectedBytesRead+=READ_CHUNK_SIZE;
              expectedBytesReadList.add(totalBytesRead.addAndGet(READ_CHUNK_SIZE));
            }
          }
        }
      }
    }
);
  }
  executorService.shutdown();
  executorService.awaitTermination(EXECUTION_SERVICE_TIMEOUT_IN_SECONDS,TimeUnit.SECONDS);
  ArgumentCaptor<Long> bytesReadArgumentCaptor=ArgumentCaptor.forClass(Long.class);
  verify(mockProgressReporter,times(expectedBytesReadList.size())).onProgress(bytesReadArgumentCaptor.capture(),eq(totalBytes));
  assertEquals(expectedBytesReadList,bytesReadArgumentCaptor.getAllValues());
}
