@Test public void testSyncMultSeriesReader() throws IOException, StorageEngineException {
  ClusterDescriptor.getInstance().getConfig().setUseAsyncServer(false);
  setSyncDataClient();
  PartitionGroup group=new PartitionGroup();
  group.add(TestUtils.getNode(0));
  group.add(TestUtils.getNode(1));
  group.add(TestUtils.getNode(2));
  MultSeriesQueryRequest request=new MultSeriesQueryRequest();
  RemoteQueryContext context=new RemoteQueryContext(1);
  try {
    MultDataSourceInfo sourceInfo=new MultDataSourceInfo(group,paths,dataTypes,request,context,metaGroupMember,group);
    sourceInfo.hasNextDataClient(Long.MIN_VALUE);
    reader=new RemoteMultSeriesReader(sourceInfo);
    for (int i=0; i < 100; i++) {
      assertTrue(reader.hasNextTimeValuePair(paths.get(0).getFullPath()));
      TimeValuePair pair=reader.nextTimeValuePair(paths.get(0).getFullPath());
      assertEquals(i,pair.getTimestamp());
      assertEquals(i * 1.0,pair.getValue().getDouble(),0.00001);
    }
    assertFalse(reader.hasNextTimeValuePair(paths.get(0).getFullPath()));
    for (int i=0; i < 100; i++) {
      assertTrue(reader.hasNextTimeValuePair(paths.get(1).getFullPath()));
      TimeValuePair pair=reader.nextTimeValuePair(paths.get(1).getFullPath());
      assertEquals(i,pair.getTimestamp());
      assertEquals(i * 1.0,pair.getValue().getInt(),0.00001);
    }
    assertFalse(reader.hasNextTimeValuePair(paths.get(1).getFullPath()));
  }
  finally {
    QueryResourceManager.getInstance().endQuery(context.getQueryId());
  }
}
