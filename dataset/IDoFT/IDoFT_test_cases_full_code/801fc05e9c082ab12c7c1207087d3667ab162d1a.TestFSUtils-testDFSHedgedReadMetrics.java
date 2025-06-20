/** 
 * Ugly test that ensures we can get at the hedged read counters in dfsclient. Does a bit of preading with hedged reads enabled using code taken from hdfs TestPread.
 * @throws Exception
 */
@Test public void testDFSHedgedReadMetrics() throws Exception {
  conf.setInt(DFSConfigKeys.DFS_DFSCLIENT_HEDGED_READ_THREADPOOL_SIZE,5);
  conf.setLong(DFSConfigKeys.DFS_DFSCLIENT_HEDGED_READ_THRESHOLD_MILLIS,0);
  conf.setLong(DFSConfigKeys.DFS_BLOCK_SIZE_KEY,4096);
  conf.setLong(DFSConfigKeys.DFS_CLIENT_READ_PREFETCH_SIZE_KEY,4096);
  conf.setInt(DFSConfigKeys.DFS_CLIENT_RETRY_WINDOW_BASE,0);
  conf.setBoolean("dfs.datanode.transferTo.allowed",false);
  MiniDFSCluster cluster=new MiniDFSCluster.Builder(conf).numDataNodes(3).build();
  DFSHedgedReadMetrics metrics=FSUtils.getDFSHedgedReadMetrics(conf);
  assertEquals(0,metrics.getHedgedReadOps());
  FileSystem fileSys=cluster.getFileSystem();
  try {
    Path p=new Path("preadtest.dat");
    DFSTestUtil.createFile(fileSys,p,12 * blockSize,12 * blockSize,blockSize,(short)3,seed);
    pReadFile(fileSys,p);
    cleanupFile(fileSys,p);
    assertTrue(metrics.getHedgedReadOps() > 0);
  }
  finally {
    fileSys.close();
    cluster.shutdown();
  }
}
