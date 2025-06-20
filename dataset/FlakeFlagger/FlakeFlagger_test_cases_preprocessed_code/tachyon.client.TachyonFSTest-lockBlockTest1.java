@Test public void lockBlockTest1() throws IOException {
Assert.assertTrue(tFile.isInMemory());
Assert.assertFalse(tFile.isInMemory());
Assert.assertTrue(tFile.isInMemory());
}