@Test public void testCreateNewInstantTime() throws Exception {
assertTrue(HoodieTimeline.compareTimestamps(lastInstantTime,HoodieTimeline.LESSER_THAN,newInstantTime));
ExecutorService executorService=Executors.newFixedThreadPool(numThreads);
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
if (!curFormat.equals(expectedFormat)) {
}
executorService.shutdown();
assertTrue(executorService.awaitTermination(10,TimeUnit.SECONDS));
f.get();
}