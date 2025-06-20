@Test @TestDir @TestJetty @TestHdfs public void testGetSnapshotDiffIllegalParam() throws Exception {
Assert.assertTrue(dfs.getFileStatus(path).isSnapshotEnabled());
}