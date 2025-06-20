@Test public void unlockBlockTest3() throws IOException {
Assert.assertTrue(tFile.isInMemory());
Assert.assertNotNull(tBuf1);
Assert.assertNotNull(tBuf2);
Assert.assertFalse(tFile.isInMemory());
Assert.assertTrue(tFile.isInMemory());
}