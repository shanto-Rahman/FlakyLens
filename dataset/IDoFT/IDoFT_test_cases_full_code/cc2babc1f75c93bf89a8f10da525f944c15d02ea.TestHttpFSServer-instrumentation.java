@Test @TestDir @TestJetty @TestHdfs public void instrumentation() throws Exception {
  createHttpFSServer(false,false);
  URL url=new URL(TestJettyHelper.getJettyURL(),MessageFormat.format("/webhdfs/v1?user.name={0}&op=instrumentation","nobody"));
  HttpURLConnection conn=(HttpURLConnection)url.openConnection();
  Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_UNAUTHORIZED);
  url=new URL(TestJettyHelper.getJettyURL(),MessageFormat.format("/webhdfs/v1?user.name={0}&op=instrumentation",HadoopUsersConfTestHelper.getHadoopUsers()[0]));
  conn=(HttpURLConnection)url.openConnection();
  Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
  BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
  String line=reader.readLine();
  reader.close();
  Assert.assertTrue(line.contains("\"counters\":{"));
  url=new URL(TestJettyHelper.getJettyURL(),MessageFormat.format("/webhdfs/v1/foo?user.name={0}&op=instrumentation",HadoopUsersConfTestHelper.getHadoopUsers()[0]));
  conn=(HttpURLConnection)url.openConnection();
  Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_BAD_REQUEST);
}
