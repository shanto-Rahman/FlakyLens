@Test public void deleteFileTest() throws InvalidPathException, FileAlreadyExistException, TachyonException, BlockInfoException {
Assert.assertEquals(fileId,mMasterInfo.getFileId("/testFile"));
Assert.assertTrue(mMasterInfo.delete(fileId,true));
Assert.assertEquals(-1,mMasterInfo.getFileId("/testFile"));
}