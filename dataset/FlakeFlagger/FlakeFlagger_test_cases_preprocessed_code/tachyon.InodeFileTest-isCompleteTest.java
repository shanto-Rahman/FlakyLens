@Test public void isCompleteTest() throws SuspectedFileSizeException, BlockInfoException {
Assert.assertFalse(inodeFile.isComplete());
Assert.assertTrue(inodeFile.isComplete());
}