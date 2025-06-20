@Test public void testCreateNewInstantTime() throws Exception {
  String lastInstantTime=HoodieActiveTimeline.createNewInstantTime();
  for (int i=0; i < 3; ++i) {
    String newInstantTime=HoodieActiveTimeline.createNewInstantTime();
    assertTrue(HoodieTimeline.compareTimestamps(lastInstantTime,HoodieTimeline.LESSER_THAN,newInstantTime));
    lastInstantTime=newInstantTime;
  }
  HoodieActiveTimeline.parseDateFromInstantTime("00000000000000");
  final int numChecks=100000;
  final int numThreads=100;
  final long milliSecondsInYear=365 * 24 * 3600* 1000;
  ExecutorService executorService=Executors.newFixedThreadPool(numThreads);
  List<Future> futures=new ArrayList<>(numThreads);
  for (int idx=0; idx < numThreads; ++idx) {
    futures.add(executorService.submit(() -> {
      Date date=new Date(System.currentTimeMillis() + (int)(Math.random() * numThreads) * milliSecondsInYear);
      final String expectedFormat=HoodieActiveTimeline.formatDate(date);
      for (int tidx=0; tidx < numChecks; ++tidx) {
        final String curFormat=HoodieActiveTimeline.formatDate(date);
        if (!curFormat.equals(expectedFormat)) {
          throw new HoodieException("Format error: expected=" + expectedFormat + ", curFormat="+ curFormat);
        }
      }
    }
));
  }
  executorService.shutdown();
  assertTrue(executorService.awaitTermination(10,TimeUnit.SECONDS));
  for (  Future f : futures) {
    f.get();
  }
}
