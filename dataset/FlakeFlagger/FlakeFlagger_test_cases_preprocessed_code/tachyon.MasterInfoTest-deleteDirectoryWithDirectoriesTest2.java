@Test public void deleteDirectoryWithDirectoriesTest2() throws InvalidPathException, FileAlreadyExistException, TachyonException, BlockInfoException {
Assert.assertTrue(mMasterInfo.mkdir("/testFolder"));
Assert.assertTrue(mMasterInfo.mkdir("/testFolder/testFolder2"));
Assert.assertEquals(2,mMasterInfo.getFileId("/testFolder"));
Assert.assertEquals(3,mMasterInfo.getFileId("/testFolder/testFolder2"));
Assert.assertEquals(fileId,mMasterInfo.getFileId("/testFolder/testFile"));
Assert.assertEquals(fileId2,mMasterInfo.getFileId("/testFolder/testFolder2/testFile2"));
Assert.assertFalse(mMasterInfo.delete(2,false));
Assert.assertEquals(2,mMasterInfo.getFileId("/testFolder"));
Assert.assertEquals(3,mMasterInfo.getFileId("/testFolder/testFolder2"));
Assert.assertEquals(fileId,mMasterInfo.getFileId("/testFolder/testFile"));
Assert.assertEquals(fileId2,mMasterInfo.getFileId("/testFolder/testFolder2/testFile2"));
}