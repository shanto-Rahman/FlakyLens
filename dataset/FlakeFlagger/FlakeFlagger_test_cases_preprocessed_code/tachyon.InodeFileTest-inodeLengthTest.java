@Test public void inodeLengthTest() throws SuspectedFileSizeException, BlockInfoException {
Assert.assertEquals(testLength,inodeFile.getLength());
}