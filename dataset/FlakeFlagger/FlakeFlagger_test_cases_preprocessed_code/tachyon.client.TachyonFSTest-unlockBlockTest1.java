@Test public void unlockBlockTest1() throws IOException {
Assert.assertTrue(tFile.isInMemory());
Assert.assertNotNull(tBuf);
Assert.assertFalse(tFile.isInMemory());
Assert.assertTrue(tFile.isInMemory());
}