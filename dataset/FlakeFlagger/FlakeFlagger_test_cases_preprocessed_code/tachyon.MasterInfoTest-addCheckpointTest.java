@Test public void addCheckpointTest() throws FileDoesNotExistException, SuspectedFileSizeException, FileAlreadyExistException, InvalidPathException, BlockInfoException, FileNotFoundException, TachyonException {
Assert.assertEquals("",fileInfo.getCheckpointPath());
Assert.assertEquals("/testPath",fileInfo.getCheckpointPath());
Assert.assertEquals("/testPath",fileInfo.getCheckpointPath());
}