@Test @TestDir @TestJetty @TestHdfs public void testCreateSnapshotNoSnapshotName() throws Exception {
  createHttpFSServer(false,false);
  final HttpURLConnection conn=snapshotTestPreconditions("PUT","CREATESNAPSHOT","");
  Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
  final BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
  String result=reader.readLine();
  Assert.assertTrue(Pattern.matches("(\\{\\\"Path\\\"\\:\\\"/tmp/tmp-snap-test/.snapshot/s)" + "(\\d{8})(-)(\\d{6})(\\.)(\\d{3})(\\\"\\})",result));
  result=getStatus("/tmp/tmp-snap-test/.snapshot","LISTSTATUS");
  Assert.assertTrue(Pattern.matches("(.+)(\\\"pathSuffix\\\":\\\"s)" + "(\\d{8})(-)(\\d{6})(\\.)(\\d{3})(\\\")(.+)",result));
}
