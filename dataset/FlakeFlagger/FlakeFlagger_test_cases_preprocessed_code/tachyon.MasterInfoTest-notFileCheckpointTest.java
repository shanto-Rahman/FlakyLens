@Test(expected=FileNotFoundException.class) public void notFileCheckpointTest() throws FileNotFoundException, SuspectedFileSizeException, FileAlreadyExistException, InvalidPathException, BlockInfoException, TachyonException {
Assert.assertTrue(mMasterInfo.mkdir("/testFile"));
}