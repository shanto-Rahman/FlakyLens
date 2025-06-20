@Test @TestDir @TestJetty @TestHdfs public void testOpenOffsetLength() throws Exception {
  createHttpFSServer(false,false);
  byte[] array=new byte[]{0,1,2,3};
  FileSystem fs=FileSystem.get(TestHdfsHelper.getHdfsConf());
  fs.mkdirs(new Path("/tmp"));
  OutputStream os=fs.create(new Path("/tmp/foo"));
  os.write(array);
  os.close();
  String user=HadoopUsersConfTestHelper.getHadoopUsers()[0];
  URL url=new URL(TestJettyHelper.getJettyURL(),MessageFormat.format("/webhdfs/v1/tmp/foo?user.name={0}&op=open&offset=1&length=2",user));
  HttpURLConnection conn=(HttpURLConnection)url.openConnection();
  Assert.assertEquals(HttpURLConnection.HTTP_OK,conn.getResponseCode());
  InputStream is=conn.getInputStream();
  Assert.assertEquals(1,is.read());
  Assert.assertEquals(2,is.read());
  Assert.assertEquals(-1,is.read());
}
