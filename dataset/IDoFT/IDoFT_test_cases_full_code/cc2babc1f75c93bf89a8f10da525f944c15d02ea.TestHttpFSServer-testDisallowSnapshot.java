@Test @TestDir @TestJetty @TestHdfs public void testDisallowSnapshot() throws Exception {
  createHttpFSServer(false,false);
  String pathString="/tmp/tmp-snap-disallow-test";
  createDirWithHttp(pathString,"700",null);
  Path path=new Path(pathString);
  DistributedFileSystem dfs=(DistributedFileSystem)FileSystem.get(path.toUri(),TestHdfsHelper.getHdfsConf());
  dfs.allowSnapshot(path);
  Assert.assertTrue(dfs.getFileStatus(path).isSnapshotEnabled());
  String user=HadoopUsersConfTestHelper.getHadoopUsers()[0];
  URL url=new URL(TestJettyHelper.getJettyURL(),MessageFormat.format("/webhdfs/v1{0}?user.name={1}&op=DISALLOWSNAPSHOT",pathString,user));
  HttpURLConnection conn=(HttpURLConnection)url.openConnection();
  conn.setRequestMethod("PUT");
  conn.connect();
  Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
  Assert.assertFalse(dfs.getFileStatus(path).isSnapshotEnabled());
  dfs.delete(path,true);
}
