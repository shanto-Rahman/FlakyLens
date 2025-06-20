@Test public void testMultManagerMergeRemoteSeriesReader() throws IOException, StorageEngineException {
  ClusterDescriptor.getInstance().getConfig().setUseAsyncServer(true);
  PartitionGroup group=new PartitionGroup();
  setAsyncDataClient();
  group.add(TestUtils.getNode(0));
  group.add(TestUtils.getNode(1));
  group.add(TestUtils.getNode(2));
  MultSeriesQueryRequest request=new MultSeriesQueryRequest();
  RemoteQueryContext context=new RemoteQueryContext(1);
  try {
    MultDataSourceInfo sourceInfo=new MultDataSourceInfo(group,paths,dataTypes,request,context,metaGroupMember,group);
    sourceInfo.hasNextDataClient(Long.MIN_VALUE);
    reader=new RemoteMultSeriesReader(sourceInfo);
    assignPathManagedMergeReader.addReader(reader,0);
    for (int i=0; i < 100; i++) {
      assertEquals(true,assignPathManagedMergeReader.hasNextTimeValuePair());
      TimeValuePair pair=assignPathManagedMergeReader.nextTimeValuePair();
      assertEquals(i,pair.getTimestamp());
      assertEquals(i * 1.0,pair.getValue().getDouble(),0.00001);
    }
    assertEquals(false,assignPathManagedMergeReader.hasNextTimeValuePair());
  }
  finally {
    QueryResourceManager.getInstance().endQuery(context.getQueryId());
  }
}
