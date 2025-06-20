@Test @TestDir @TestJetty @TestHdfs public void testDisallowSnapshotException() throws Exception {
  createHttpFSServer(false,false);
  String pathString="/tmp/tmp-snap-disallow-exception-test";
  createDirWithHttp(pathString,"700",null);
  Path path=new Path(pathString);
  DistributedFileSystem dfs=(DistributedFileSystem)FileSystem.get(path.toUri(),TestHdfsHelper.getHdfsConf());
  dfs.allowSnapshot(path);
  Assert.assertTrue(dfs.getFileStatus(path).isSnapshotEnabled());
  dfs.createSnapshot(path,"snap-01");
  dfs.createSnapshot(path,"snap-02");
  String user=HadoopUsersConfTestHelper.getHadoopUsers()[0];
  URL url=new URL(TestJettyHelper.getJettyURL(),MessageFormat.format("/webhdfs/v1{0}?user.name={1}&op=DISALLOWSNAPSHOT",pathString,user));
  HttpURLConnection conn=(HttpURLConnection)url.openConnection();
  conn.setRequestMethod("PUT");
  conn.connect();
  Assert.assertNotEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
  Assert.assertTrue(dfs.getFileStatus(path).isSnapshotEnabled());
  dfs.deleteSnapshot(path,"snap-02");
  dfs.deleteSnapshot(path,"snap-01");
  dfs.delete(path,true);
}
