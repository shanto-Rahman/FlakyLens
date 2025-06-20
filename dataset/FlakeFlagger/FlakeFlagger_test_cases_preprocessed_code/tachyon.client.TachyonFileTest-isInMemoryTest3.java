/** 
 * Test LRU Cache Eviction + PIN.
 * @throws InvalidPathException
 * @throws FileAlreadyExistException
 * @throws IOException
 */
@Test public void isInMemoryTest3() throws InvalidPathException, FileAlreadyExistException, IOException {
Assert.assertTrue(file.isInMemory());
Assert.assertTrue(file.isInMemory());
Assert.assertTrue(file.isInMemory());
Assert.assertFalse(file.isInMemory());
Assert.assertTrue(file.isInMemory());
}