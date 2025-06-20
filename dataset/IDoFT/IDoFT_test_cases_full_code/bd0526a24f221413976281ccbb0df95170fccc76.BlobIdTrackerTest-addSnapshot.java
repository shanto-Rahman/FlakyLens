@Test public void addSnapshot() throws Exception {
  LOG.info("In addSnapshot");
  Set<String> initAdd=add(tracker,range(0,4));
  ScheduledFuture<?> scheduledFuture=scheduler.schedule(tracker.new SnapshotJob(),0,TimeUnit.MILLISECONDS);
  scheduledFuture.get();
  Set<String> retrieved=retrieve(tracker);
  assertEquals("Extra elements after add",initAdd,retrieved);
  assertTrue(read(dataStore.getAllMetadataRecords(BLOBREFERENCES.getType())).isEmpty());
}
