@Test public void inMemoryTest() throws BlockInfoException {
Assert.assertFalse(inodeFile.isFullyInMemory());
Assert.assertTrue(inodeFile.isFullyInMemory());
Assert.assertFalse(inodeFile.isFullyInMemory());
Assert.assertTrue(inodeFile.isFullyInMemory());
Assert.assertFalse(inodeFile.isFullyInMemory());
Assert.assertTrue(inodeFile.isFullyInMemory());
Assert.assertTrue(inodeFile.isFullyInMemory());
}