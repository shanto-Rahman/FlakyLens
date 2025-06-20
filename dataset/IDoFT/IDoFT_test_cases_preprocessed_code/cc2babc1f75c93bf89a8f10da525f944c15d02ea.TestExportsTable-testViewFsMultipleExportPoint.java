@Test public void testViewFsMultipleExportPoint() throws IOException {
assertTrue(rpcMount.getExports().size() == 2);
assertTrue(exportInMountd1.equals("/hdfs1"));
assertTrue(exportInMountd2.equals("/hdfs2"));
if (cluster != null) {
}
}