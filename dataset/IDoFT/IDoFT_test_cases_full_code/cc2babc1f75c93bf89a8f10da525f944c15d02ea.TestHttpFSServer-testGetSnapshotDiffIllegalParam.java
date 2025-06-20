@Test @TestDir @TestJetty @TestHdfs public void testGetSnapshotDiffIllegalParam() throws Exception {
  createHttpFSServer(false,false);
  String pathStr="/tmp/tmp-snap-diff-exc-test";
  createDirWithHttp(pathStr,"700",null);
  Path path=new Path(pathStr);
  DistributedFileSystem dfs=(DistributedFileSystem)FileSystem.get(path.toUri(),TestHdfsHelper.getHdfsConf());
  dfs.allowSnapshot(path);
  Assert.assertTrue(dfs.getFileStatus(path).isSnapshotEnabled());
  HttpURLConnection conn=sendRequestGetSnapshotDiff(pathStr,"","");
  Assert.assertNotEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
  sendRequestGetSnapshotDiff(pathStr,"snap1","");
  Assert.assertNotEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
  sendRequestGetSnapshotDiff(pathStr,"","snap2");
  Assert.assertNotEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
  sendRequestGetSnapshotDiff(pathStr,"snap1","snap2");
  Assert.assertNotEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
  dfs.delete(path,true);
}
