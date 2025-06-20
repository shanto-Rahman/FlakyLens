@Test @TestDir @TestJetty @TestHdfs public void testRenameSnapshot() throws Exception {
  createHttpFSServer(false,false);
  HttpURLConnection conn=snapshotTestPreconditions("PUT","CREATESNAPSHOT","snapshotname=snap-to-rename");
  Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
  conn=snapshotTestPreconditions("PUT","RENAMESNAPSHOT","oldsnapshotname=snap-to-rename" + "&snapshotname=snap-renamed");
  Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
  String result=getStatus("/tmp/tmp-snap-test/.snapshot","LISTSTATUS");
  Assert.assertTrue(result.contains("snap-renamed"));
  Assert.assertFalse(result.contains("snap-to-rename"));
}
