@Test public void snapshotIgnoreAfterRemove() throws Exception {
  LOG.info("In snapshotIgnoreAfterRemove");
  BlobIdTracker.SnapshotJob job=tracker.new SnapshotJob();
  snapshotRemove(job,false);
  ScheduledFuture<?> scheduledFuture=scheduler.schedule(job,0,TimeUnit.MILLISECONDS);
  scheduledFuture.get();
  assertTrue("Snapshot not skipped",read(dataStore.getAllMetadataRecords(BLOBREFERENCES.getType())).isEmpty());
}
