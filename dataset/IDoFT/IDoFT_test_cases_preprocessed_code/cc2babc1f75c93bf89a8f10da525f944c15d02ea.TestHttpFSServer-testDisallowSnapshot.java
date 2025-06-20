@Test @TestDir @TestJetty @TestHdfs public void testDisallowSnapshot() throws Exception {
Assert.assertTrue(dfs.getFileStatus(path).isSnapshotEnabled());
Assert.assertEquals(conn.getResponseCode(),HttpURLConnection.HTTP_OK);
Assert.assertFalse(dfs.getFileStatus(path).isSnapshotEnabled());
}