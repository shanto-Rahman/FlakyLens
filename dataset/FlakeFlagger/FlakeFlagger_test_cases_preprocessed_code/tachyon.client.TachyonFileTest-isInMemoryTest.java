/** 
 * Basic isInMemory Test.
 * @throws InvalidPathException
 * @throws FileAlreadyExistException
 * @throws IOException
 */
@Test public void isInMemoryTest() throws InvalidPathException, FileAlreadyExistException, IOException {
Assert.assertTrue(file.isInMemory());
Assert.assertTrue(file.isInMemory());
Assert.assertFalse(file.isInMemory());
Assert.assertTrue(file.recache());
Assert.assertTrue(file.isInMemory());
Assert.assertFalse(file.isInMemory());
Assert.assertFalse(file.recache());
Assert.assertFalse(file.isInMemory());
Assert.assertFalse(file.isInMemory());
Assert.assertTrue(file.recache());
Assert.assertTrue(file.isInMemory());
}