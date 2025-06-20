@Test @TestDir @TestJetty @TestHdfs public void testGetSnapshotDiff() throws Exception {
Assert.assertTrue(dfs.getFileStatus(path).isSnapshotEnabled());
Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
Assert.assertEquals(result,JsonUtil.toJsonString(dfsDiffReport));
}