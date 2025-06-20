@Test public void createFileTest() throws InvalidPathException, FileAlreadyExistException, FileDoesNotExistException, BlockInfoException, TachyonException {
Assert.assertFalse(mMasterInfo.getClientFileInfo("/testFile").isFolder());
}