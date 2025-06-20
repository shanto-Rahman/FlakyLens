@Test @TestDir @TestJetty @TestHdfs public void testAllowSnapshot() throws Exception {
Assert.assertFalse(dfs.getFileStatus(path).isSnapshotEnabled());
Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
Assert.assertTrue(dfs.getFileStatus(path).isSnapshotEnabled());
}