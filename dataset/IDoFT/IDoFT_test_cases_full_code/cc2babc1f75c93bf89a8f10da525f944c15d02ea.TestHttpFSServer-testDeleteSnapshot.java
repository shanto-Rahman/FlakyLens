@Test @TestDir @TestJetty @TestHdfs public void testDeleteSnapshot() throws Exception {
  createHttpFSServer(false,false);
  HttpURLConnection conn=snapshotTestPreconditions("PUT","CREATESNAPSHOT","snapshotname=snap-to-delete");
  Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
  conn=snapshotTestPreconditions("DELETE","DELETESNAPSHOT","snapshotname=snap-to-delete");
  Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
  String result=getStatus("/tmp/tmp-snap-test/.snapshot","LISTSTATUS");
  Assert.assertFalse(result.contains("snap-to-delete"));
}
