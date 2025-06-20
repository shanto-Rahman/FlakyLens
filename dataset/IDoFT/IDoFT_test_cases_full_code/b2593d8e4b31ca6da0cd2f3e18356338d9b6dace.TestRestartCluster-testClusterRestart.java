@Test(timeout=300000) public void testClusterRestart() throws Exception {
  UTIL.startMiniCluster(3);
  while (!UTIL.getMiniWaspCluster().getMaster().isInitialized()) {
    Threads.sleep(1);
  }
  LOG.info("\n\nCreating tables");
  for (  byte[] TABLE : TABLES) {
    UTIL.createTable(TABLE);
  }
  for (  byte[] TABLE : TABLES) {
    UTIL.waitTableAvailable(TABLE,30000);
  }
  List<EntityGroupInfo> allEntityGroups=FMetaScanner.listAllEntityGroups(UTIL.getConfiguration());
  assertEquals(3,allEntityGroups.size());
  LOG.info("\n\nShutting down cluster");
  UTIL.shutdownMiniWaspCluster();
  LOG.info("\n\nSleeping a bit");
  Thread.sleep(2000);
  LOG.info("\n\nStarting cluster the second time");
  UTIL.restartWaspCluster(3);
  allEntityGroups=FMetaScanner.listAllEntityGroups(new Configuration(UTIL.getConfiguration()));
  assertEquals(3,allEntityGroups.size());
  LOG.info("\n\nWaiting for tables to be available");
  for (  byte[] TABLE : TABLES) {
    try {
      UTIL.createTable(TABLE);
      assertTrue("Able to create table that should already exist",false);
    }
 catch (    Exception t) {
      if (t instanceof RemoteException) {
        t=((RemoteException)t).unwrapRemoteException();
      }
      if (t.getClass().getName().equals("com.alibaba.wasp.TableExistsException")) {
        LOG.info("Table already exists as expected");
      }
 else {
        throw t;
      }
    }
    UTIL.waitTableAvailable(TABLE,30000);
  }
  UTIL.shutdownMiniCluster();
}
