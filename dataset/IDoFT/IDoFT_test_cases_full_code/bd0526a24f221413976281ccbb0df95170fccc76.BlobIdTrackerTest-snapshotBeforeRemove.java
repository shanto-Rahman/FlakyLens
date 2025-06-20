@Test public void snapshotBeforeRemove() throws Exception {
  LOG.info("In snapshotBeforeRemove");
  Clock clock=Clock.ACCURATE;
  BlobIdTracker.SnapshotJob job=tracker.new SnapshotJob(100,clock);
  Set<String> present=snapshotRemove(job,true);
  clock.waitUntil(System.currentTimeMillis() + 100);
  ScheduledFuture<?> scheduledFuture=scheduler.schedule(job,0,TimeUnit.MILLISECONDS);
  scheduledFuture.get();
  assertEquals("Elements not equal after snapshot after remove",present,read(dataStore.getAllMetadataRecords(BLOBREFERENCES.getType())));
}
