@Test public void externalAddOffline() throws Exception {
  LOG.info("In externalAddOffline");
  closer.close();
  root=folder.newFolder();
  File blobIdRoot=new File(root,"blobids");
  blobIdRoot.mkdirs();
  File offline=new File(blobIdRoot,"blob-offline123456.gen");
  List<String> offlineLoad=range(0,1000);
  FileIOUtils.writeStrings(offlineLoad.iterator(),offline,false);
  this.tracker=BlobIdTracker.build(root.getAbsolutePath(),repoId,100 * 60,dataStore);
  this.scheduler=newSingleThreadScheduledExecutor();
  closer.register(tracker);
  closer.register(new ExecutorCloser(scheduler));
  Set<String> initAdd=add(tracker,range(1001,1005));
  ScheduledFuture<?> scheduledFuture=scheduler.schedule(tracker.new SnapshotJob(),0,TimeUnit.MILLISECONDS);
  scheduledFuture.get();
  initAdd.addAll(offlineLoad);
  assertEquals(initAdd.size(),Iterators.size(tracker.get()));
  Set<String> retrieved=retrieve(tracker);
  assertEquals("Extra elements after add",initAdd,retrieved);
  assertTrue(read(dataStore.getAllMetadataRecords(BLOBREFERENCES.getType())).isEmpty());
}
