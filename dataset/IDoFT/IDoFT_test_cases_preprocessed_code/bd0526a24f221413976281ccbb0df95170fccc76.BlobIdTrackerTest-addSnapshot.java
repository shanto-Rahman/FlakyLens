@Test public void addSnapshot() throws Exception {
ScheduledFuture<?> scheduledFuture=scheduler.schedule(tracker.new SnapshotJob(),0,TimeUnit.MILLISECONDS);
scheduledFuture.get();
assertEquals("Extra elements after add",initAdd,retrieved);
assertTrue(read(dataStore.getAllMetadataRecords(BLOBREFERENCES.getType())).isEmpty());
}