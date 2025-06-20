/** 
 * Simple test of shutdown. <p> Starts with three masters. Tells the active master to shutdown the cluster. Verifies that all masters are properly shutdown.
 * @throws Exception
 */
@Test(timeout=240000) public void testMasterShutdown() throws Exception {
  final int NUM_MASTERS=3;
  final int NUM_RS=3;
  WaspTestingUtility TEST_UTIL=new WaspTestingUtility(conf);
  TEST_UTIL.startMiniCluster(NUM_MASTERS,NUM_RS);
  MiniWaspCluster cluster=TEST_UTIL.getWaspCluster();
  List<MasterThread> masterThreads=cluster.getMasterThreads();
  for (  MasterThread mt : masterThreads) {
    assertTrue(mt.isAlive());
  }
  FMaster active=null;
  for (int i=0; i < masterThreads.size(); i++) {
    if (masterThreads.get(i).getMaster().isActiveMaster()) {
      active=masterThreads.get(i).getMaster();
      break;
    }
  }
  assertNotNull(active);
  ClusterStatus status=active.getClusterStatus();
  assertEquals(2,status.getBackupMastersSize());
  assertEquals(2,status.getBackupMasters().size());
  active.shutdown();
  for (int i=NUM_MASTERS - 1; i >= 0; --i) {
    cluster.waitOnMaster(i);
  }
  assertEquals(0,masterThreads.size());
  TEST_UTIL.shutdownMiniCluster();
}
