@Test(timeout=100000) public void testRestartClusterAfterKill() throws Exception {
  LOG.info("Starting Wasp cluster...");
  UTIL.startMiniCluster(2);
  while (!UTIL.getMiniWaspCluster().getMaster().isInitialized()) {
    Threads.sleep(1);
  }
  try {
    UTIL.createTable(TABLENAME);
    UTIL.waitTableEnabled(TABLENAME,30000);
    LOG.info("Created a table, waiting for table to be available...");
    UTIL.waitTableAvailable(TABLENAME,30000);
    LOG.info("Master deleted unassigned entityGroup and started up successfully.");
  }
 catch (  Exception e) {
    throw e;
  }
 finally {
    UTIL.shutdownMiniCluster();
  }
}
