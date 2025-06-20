@Test public void externalAddOffline() throws Exception {
File blobIdRoot=new File(root,"blobids");
File offline=new File(blobIdRoot,"blob-offline123456.gen");
ScheduledFuture<?> scheduledFuture=scheduler.schedule(tracker.new SnapshotJob(),0,TimeUnit.MILLISECONDS);
scheduledFuture.get();
assertEquals(initAdd.size(),Iterators.size(tracker.get()));
assertEquals("Extra elements after add",initAdd,retrieved);
assertTrue(read(dataStore.getAllMetadataRecords(BLOBREFERENCES.getType())).isEmpty());
}