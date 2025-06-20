@Test public void unlockBlockTest2() throws IOException {
Assert.assertTrue(tFile.isInMemory());
Assert.assertNotNull(tBuf);
Assert.assertNotNull(tBuf);
Assert.assertTrue(tFile.isInMemory());
Assert.assertFalse(tFile.isInMemory());
}