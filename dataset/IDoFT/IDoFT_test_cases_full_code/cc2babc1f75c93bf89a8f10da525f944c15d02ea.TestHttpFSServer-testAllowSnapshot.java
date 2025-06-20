@Test @TestDir @TestJetty @TestHdfs public void testAllowSnapshot() throws Exception {
  createHttpFSServer(false,false);
  String pathString="/tmp/tmp-snap-allow-test";
  createDirWithHttp(pathString,"700",null);
  Path path=new Path(pathString);
  DistributedFileSystem dfs=(DistributedFileSystem)FileSystem.get(path.toUri(),TestHdfsHelper.getHdfsConf());
  Assert.assertFalse(dfs.getFileStatus(path).isSnapshotEnabled());
  String user=HadoopUsersConfTestHelper.getHadoopUsers()[0];
  URL url=new URL(TestJettyHelper.getJettyURL(),MessageFormat.format("/webhdfs/v1{0}?user.name={1}&op=ALLOWSNAPSHOT",pathString,user));
  HttpURLConnection conn=(HttpURLConnection)url.openConnection();
  conn.setRequestMethod("PUT");
  conn.connect();
  Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
  Assert.assertTrue(dfs.getFileStatus(path).isSnapshotEnabled());
  dfs.delete(path,true);
}
