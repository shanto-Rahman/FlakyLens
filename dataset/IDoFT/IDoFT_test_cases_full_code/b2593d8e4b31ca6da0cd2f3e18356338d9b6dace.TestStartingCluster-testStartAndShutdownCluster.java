@Test(timeout=300000) public void testStartAndShutdownCluster() throws Exception {
  WaspTestingUtility waspTestingUtility=new WaspTestingUtility();
  waspTestingUtility.getConfiguration().setClass(FConstants.REDO_IMPL,MemRedoLog.class,Redo.class);
  try {
    waspTestingUtility.startMiniCluster(1);
    byte[] tableName=Bytes.toBytes("testStartAndShutdownCluster");
    waspTestingUtility.createTable(tableName);
    waspTestingUtility.waitTableEnabled(tableName,60 * 1000);
    waspTestingUtility.getWaspCluster().getEntityGroups(tableName);
  }
 catch (  Throwable t) {
    LOG.warn("Failed starting mini cluster",t);
    fail("Failed starting cluster");
  }
 finally {
    waspTestingUtility.shutdownMiniCluster();
  }
  try {
    waspTestingUtility.startMiniCluster(1);
    byte[] tableName=Bytes.toBytes("testStartAndShutdownCluster");
    waspTestingUtility.createTable(tableName);
    waspTestingUtility.waitTableEnabled(tableName,60 * 1000);
    waspTestingUtility.getWaspCluster().getEntityGroups(tableName);
  }
 catch (  Throwable t) {
    LOG.warn("Failed starting mini cluster",t);
    fail("Failed starting cluster");
  }
 finally {
    waspTestingUtility.shutdownMiniCluster();
  }
}
