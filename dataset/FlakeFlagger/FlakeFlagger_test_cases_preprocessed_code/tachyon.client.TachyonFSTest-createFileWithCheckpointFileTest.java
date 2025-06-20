@Test public void createFileWithCheckpointFileTest() throws IOException {
Assert.assertTrue(mTfs.exist("/abc"));
Assert.assertEquals(tempFolder + "/temp",mTfs.getCheckpointPath(mTfs.getFileId("/abc")));
}