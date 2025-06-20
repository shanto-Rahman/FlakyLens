@Test public void basicTest() throws InvalidPathException, FileAlreadyExistException, TableColumnException, TableDoesNotExistException, FileDoesNotExistException, IOException, TException {
Assert.assertTrue(column.createPartition(pid));
Assert.assertEquals("/table" + Constants.PATH_SEPARATOR + MasterInfo.COL+ col+ Constants.PATH_SEPARATOR+ pid,file.getPath());
Assert.assertEquals(5,column.partitions());
}