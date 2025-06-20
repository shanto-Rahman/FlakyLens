@Test @TestDir @TestJetty @TestHdfs public void testGetSnapshotDiff() throws Exception {
  createHttpFSServer(false,false);
  String pathStr="/tmp/tmp-snap-diff-test";
  createDirWithHttp(pathStr,"700",null);
  Path path=new Path(pathStr);
  DistributedFileSystem dfs=(DistributedFileSystem)FileSystem.get(path.toUri(),TestHdfsHelper.getHdfsConf());
  dfs.allowSnapshot(path);
  Assert.assertTrue(dfs.getFileStatus(path).isSnapshotEnabled());
  String file1=pathStr + "/file1";
  createWithHttp(file1,null);
  dfs.createSnapshot(path,"snap1");
  String file2=pathStr + "/file2";
  createWithHttp(file2,null);
  dfs.createSnapshot(path,"snap2");
  HttpURLConnection conn=sendRequestGetSnapshotDiff(pathStr,"snap1","snap2");
  Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
  BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
  String result=reader.readLine();
  SnapshotDiffReport dfsDiffReport=dfs.getSnapshotDiffReport(path,"snap1","snap2");
  Assert.assertEquals(result,JsonUtil.toJsonString(dfsDiffReport));
  dfs.deleteSnapshot(path,"snap2");
  dfs.deleteSnapshot(path,"snap1");
  dfs.delete(path,true);
}
