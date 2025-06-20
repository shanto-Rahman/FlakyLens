@Test public void openCloseTest() throws FileAlreadyExistException, InvalidPathException, TException, IOException {
Assert.assertFalse(masterClient.isConnected());
Assert.assertTrue(masterClient.isConnected());
Assert.assertTrue(masterClient.user_getFileId("/file") != -1);
Assert.assertFalse(masterClient.isConnected());
Assert.assertTrue(masterClient.isConnected());
Assert.assertTrue(masterClient.user_getFileId("/file") != -1);
}