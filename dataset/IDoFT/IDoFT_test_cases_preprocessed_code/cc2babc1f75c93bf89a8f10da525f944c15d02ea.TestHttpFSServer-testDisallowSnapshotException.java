@Test @TestDir @TestJetty @TestHdfs public void testDisallowSnapshotException() throws Exception {
Assert.assertTrue(dfs.getFileStatus(path).isSnapshotEnabled());
Assert.assertTrue(dfs.getFileStatus(path).isSnapshotEnabled());
}