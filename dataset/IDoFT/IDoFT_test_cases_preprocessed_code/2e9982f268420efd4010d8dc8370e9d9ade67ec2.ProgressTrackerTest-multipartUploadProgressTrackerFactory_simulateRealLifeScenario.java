@Test public void multipartUploadProgressTrackerFactory_simulateRealLifeScenario() throws InterruptedException {
final ExecutorService executorService=Executors.newFixedThreadPool(THREAD_POOL_SIZE);
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
int diceRoll=ThreadLocalRandom.current().nextInt();
if (diceRoll % 10 == 0) {
totalBytesRead.addAndGet(-1 * expectedBytesRead);
expectedBytesReadList.add(totalBytesRead.addAndGet(READ_CHUNK_SIZE));
}
executorService.shutdown();
executorService.awaitTermination(EXECUTION_SERVICE_TIMEOUT_IN_SECONDS,TimeUnit.SECONDS);
assertEquals(expectedBytesReadList,bytesReadArgumentCaptor.getAllValues());
}