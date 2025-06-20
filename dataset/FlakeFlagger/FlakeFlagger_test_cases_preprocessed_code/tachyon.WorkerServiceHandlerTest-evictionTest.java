@Test public void evictionTest() throws InvalidPathException, FileAlreadyExistException, IOException, FileDoesNotExistException, TException {
Assert.assertTrue(fileId1 >= 0);
Assert.assertTrue(fileInfo1.isInMemory());
Assert.assertTrue(fileId2 >= 0);
Assert.assertTrue(fileInfo1.isInMemory());
Assert.assertTrue(fileInfo2.isInMemory());
Assert.assertTrue(fileId3 >= 0);
Assert.assertFalse(fileInfo1.isInMemory());
Assert.assertTrue(fileInfo2.isInMemory());
Assert.assertTrue(fileInfo3.isInMemory());
}