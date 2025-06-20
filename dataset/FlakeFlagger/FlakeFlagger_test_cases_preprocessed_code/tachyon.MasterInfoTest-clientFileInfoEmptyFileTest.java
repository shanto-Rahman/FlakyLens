@Test public void clientFileInfoEmptyFileTest() throws InvalidPathException, FileDoesNotExistException, FileAlreadyExistException, BlockInfoException, TachyonException {
Assert.assertEquals("testFile",fileInfo.getName());
Assert.assertEquals(fileId,fileInfo.getId());
Assert.assertEquals(0,fileInfo.getLength());
Assert.assertEquals("",fileInfo.getCheckpointPath());
Assert.assertFalse(fileInfo.isFolder());
Assert.assertFalse(fileInfo.isNeedPin());
Assert.assertTrue(fileInfo.isNeedCache());
Assert.assertFalse(fileInfo.isComplete());
}