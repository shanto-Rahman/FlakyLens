@Test public void test() throws Exception {
  UTIL2.getAdmin().transitReplicationPeerSyncReplicationState(PEER_ID,SyncReplicationState.STANDBY);
  UTIL1.getAdmin().transitReplicationPeerSyncReplicationState(PEER_ID,SyncReplicationState.ACTIVE);
  UTIL1.getAdmin().disableReplicationPeer(PEER_ID);
  write(UTIL1,0,100);
  HRegionServer rs=UTIL1.getRSForFirstRegionInTable(TABLE_NAME);
  String walGroupId=AbstractFSWALProvider.getWALPrefixFromWALName(((AbstractFSWAL<?>)rs.getWAL(RegionInfoBuilder.newBuilder(TABLE_NAME).build())).getCurrentFileName().getName());
  UTIL2.getAdmin().transitReplicationPeerSyncReplicationState(PEER_ID,SyncReplicationState.DOWNGRADE_ACTIVE);
  verify(UTIL2,0,100);
  UTIL1.getAdmin().transitReplicationPeerSyncReplicationState(PEER_ID,SyncReplicationState.STANDBY);
  try (Table table=UTIL2.getConnection().getTable(TABLE_NAME)){
    for (int i=0; i < 100; i++) {
      table.delete(new Delete(Bytes.toBytes(i)));
    }
  }
   UTIL2.flush(TABLE_NAME);
  UTIL2.compact(TABLE_NAME,true);
  HRegion region=rs.getRegions(TABLE_NAME).get(0);
  UTIL1.waitFor(30000,new ExplainingPredicate<Exception>(){
    @Override public boolean evaluate() throws Exception {
      return region.get(new Get(Bytes.toBytes(99))).isEmpty();
    }
    @Override public String explainFailure() throws Exception {
      return "Replication has not been catched up yet";
    }
  }
);
  UTIL1.getAdmin().transitReplicationPeerSyncReplicationState(PEER_ID,SyncReplicationState.DOWNGRADE_ACTIVE);
  UTIL2.getAdmin().transitReplicationPeerSyncReplicationState(PEER_ID,SyncReplicationState.STANDBY);
  UTIL1.getAdmin().enableReplicationPeer(PEER_ID);
  ReplicationSource source=(ReplicationSource)((Replication)rs.getReplicationSourceService()).getReplicationManager().getSource(PEER_ID);
  UTIL1.waitFor(30000,new ExplainingPredicate<Exception>(){
    @Override public boolean evaluate() throws Exception {
      return !source.workerThreads.containsKey(walGroupId);
    }
    @Override public String explainFailure() throws Exception {
      return "Replication has not been catched up yet";
    }
  }
);
  HRegion region2=UTIL2.getMiniHBaseCluster().getRegions(TABLE_NAME).get(0);
  for (int i=0; i < 100; i++) {
    assertTrue(region2.get(new Get(Bytes.toBytes(i))).isEmpty());
  }
}
