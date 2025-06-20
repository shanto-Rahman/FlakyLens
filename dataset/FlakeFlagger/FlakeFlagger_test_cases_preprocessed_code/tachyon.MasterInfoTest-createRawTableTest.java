@Test public void createRawTableTest() throws InvalidPathException, FileAlreadyExistException, TableColumnException, FileDoesNotExistException, TachyonException {
Assert.assertTrue(mMasterInfo.getClientFileInfo("/testTable").isFolder());
}