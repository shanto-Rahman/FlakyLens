@Test public void snapshotExecuteAfterRemove() throws Exception {
ScheduledFuture<?> scheduledFuture=scheduler.schedule(job,0,TimeUnit.MILLISECONDS);
scheduledFuture.get();
assertEquals("Elements not equal after snapshot after remove",present,read(dataStore.getAllMetadataRecords(BLOBREFERENCES.getType())));
}