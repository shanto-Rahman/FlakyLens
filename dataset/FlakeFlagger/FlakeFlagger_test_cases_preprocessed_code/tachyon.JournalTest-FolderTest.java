private void FolderTest(ClientFileInfo fileInfo) throws IOException, InvalidPathException, FileDoesNotExistException {
Assert.assertEquals(2,info.ls("/",true).size());
Assert.assertTrue(info.getFileId("/") != -1);
Assert.assertTrue(info.getFileId("/xyz") != -1);
Assert.assertEquals(fileInfo,info.getClientFileInfo(info.getFileId("/xyz")));
}