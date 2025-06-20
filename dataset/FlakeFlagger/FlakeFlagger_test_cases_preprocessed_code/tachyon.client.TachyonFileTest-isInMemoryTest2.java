/** 
 * Test LRU Cache Eviction.
 * @throws InvalidPathException
 * @throws FileAlreadyExistException
 * @throws IOException
 */
@Test public void isInMemoryTest2() throws InvalidPathException, FileAlreadyExistException, IOException {
Assert.assertTrue(file.isInMemory());
Assert.assertTrue(file.isInMemory());
Assert.assertTrue(file.isInMemory());
Assert.assertFalse(file.isInMemory());
Assert.assertTrue(file.isInMemory());
}