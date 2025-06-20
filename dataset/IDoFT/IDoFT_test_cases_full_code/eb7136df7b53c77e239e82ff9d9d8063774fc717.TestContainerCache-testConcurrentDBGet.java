@Test public void testConcurrentDBGet() throws Exception {
  File root=new File(testRoot);
  root.mkdirs();
  root.deleteOnExit();
  OzoneConfiguration conf=new OzoneConfiguration();
  conf.setInt(OzoneConfigKeys.OZONE_CONTAINER_CACHE_SIZE,2);
  ContainerCache cache=ContainerCache.getInstance(conf);
  cache.clear();
  Assert.assertEquals(0,cache.size());
  File containerDir=new File(root,"cont1");
  createContainerDB(conf,containerDir);
  ExecutorService executorService=Executors.newFixedThreadPool(2);
  Runnable task=() -> {
    try {
      ReferenceCountedDB db1=cache.getDB(1,"RocksDB",containerDir.getPath(),VersionedDatanodeFeatures.SchemaV2.chooseSchemaVersion(),conf);
      Assert.assertNotNull(db1);
    }
 catch (    IOException e) {
      Assert.fail("Should get the DB instance");
    }
  }
;
  List<Future> futureList=new ArrayList<>();
  futureList.add(executorService.submit(task));
  futureList.add(executorService.submit(task));
  for (  Future future : futureList) {
    try {
      future.get();
    }
 catch (    InterruptedException|ExecutionException e) {
      Assert.fail("Should get the DB instance");
    }
  }
  ReferenceCountedDB db=cache.getDB(1,"RocksDB",containerDir.getPath(),VersionedDatanodeFeatures.SchemaV2.chooseSchemaVersion(),conf);
  db.close();
  db.close();
  db.close();
  Assert.assertEquals(1,cache.size());
  db.cleanup();
}
