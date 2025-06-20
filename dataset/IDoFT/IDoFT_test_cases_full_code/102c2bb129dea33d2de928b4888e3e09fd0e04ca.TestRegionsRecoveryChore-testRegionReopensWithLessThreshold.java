@Test public void testRegionReopensWithLessThreshold() throws Exception {
  regionNo=0;
  ClusterMetrics clusterMetrics=TestRegionsRecoveryChore.getClusterMetrics(4);
  final Map<ServerName,ServerMetrics> serverMetricsMap=clusterMetrics.getLiveServerMetrics();
  LOG.debug("All Region Names with refCount....");
  for (  ServerMetrics serverMetrics : serverMetricsMap.values()) {
    Map<byte[],RegionMetrics> regionMetricsMap=serverMetrics.getRegionMetrics();
    for (    RegionMetrics regionMetrics : regionMetricsMap.values()) {
      LOG.debug("name: " + new String(regionMetrics.getRegionName()) + " refCount: "+ regionMetrics.getStoreRefCount());
    }
  }
  Mockito.when(hMaster.getClusterMetrics()).thenReturn(clusterMetrics);
  Mockito.when(hMaster.getAssignmentManager()).thenReturn(assignmentManager);
  for (  byte[] regionName : REGION_NAME_LIST) {
    Mockito.when(assignmentManager.getRegionInfo(regionName)).thenReturn(TestRegionsRecoveryChore.getRegionInfo(regionName));
  }
  Stoppable stoppable=new StoppableImplementation();
  Configuration configuration=getCustomConf();
  configuration.setInt("hbase.regions.recovery.store.file.ref.count",400);
  regionsRecoveryChore=new RegionsRecoveryChore(stoppable,configuration,hMaster);
  regionsRecoveryChore.chore();
  Mockito.verify(hMaster,Mockito.times(1)).reopenRegions(Mockito.any(),Mockito.anyList(),Mockito.anyLong(),Mockito.anyLong());
  Mockito.verify(hMaster,Mockito.times(1)).getClusterMetrics();
  Mockito.verify(hMaster,Mockito.times(1)).getAssignmentManager();
  Mockito.verify(assignmentManager,Mockito.times(1)).getRegionInfo(Mockito.any());
}
