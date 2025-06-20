@Test public void testOpenedEntityGroupHandlerOnMasterRestart() throws Exception {
  log("Starting cluster");
  TEST_UTIL.getConfiguration().setInt("wasp.master.assignment.timeoutmonitor.period",2000);
  TEST_UTIL.getConfiguration().setInt("wasp.master.assignment.timeoutmonitor.timeout",5000);
  TEST_UTIL.startMiniCluster(NUM_MASTERS,NUM_FServer);
  String tableName="testOpenedEntityGroupHandlerOnMasterRestart";
  MiniWaspCluster cluster=createEntityGroups(tableName);
  abortMaster(cluster);
  FServer entityGroupServer=cluster.getFServer(0);
  EntityGroup entityGroup=getEntityGroupBeingServed(cluster,entityGroupServer);
  zkw=WaspTestingUtility.createAndForceNodeToOpenedState(TEST_UTIL,entityGroup,entityGroupServer.getServerName());
  log("Starting up a new master");
  cluster.startMaster().getMaster();
  log("Waiting for master to be ready");
  cluster.waitForActiveAndReadyMaster();
  log("Master is ready");
  log("Waiting for no more RIT");
  ZKAssign.blockUntilNoRIT(zkw);
}
