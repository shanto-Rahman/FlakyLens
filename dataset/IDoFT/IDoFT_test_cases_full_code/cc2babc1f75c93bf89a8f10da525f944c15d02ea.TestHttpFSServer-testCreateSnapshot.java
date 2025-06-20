@Test @TestDir @TestJetty @TestHdfs public void testCreateSnapshot() throws Exception {
  createHttpFSServer(false,false);
  final HttpURLConnection conn=snapshotTestPreconditions("PUT","CREATESNAPSHOT","snapshotname=snap-with-name");
  Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
  final BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
  String result=reader.readLine();
  Assert.assertTrue(result.equals("{\"Path\":\"/tmp/tmp-snap-test/.snapshot/snap-with-name\"}"));
  result=getStatus("/tmp/tmp-snap-test/.snapshot","LISTSTATUS");
  Assert.assertTrue(result.contains("snap-with-name"));
}
