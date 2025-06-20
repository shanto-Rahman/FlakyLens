@Test public void lockBlockTest3() throws IOException {
Assert.assertTrue(tFile.isInMemory());
if (k < numOfFiles - 1) {
Assert.assertNotNull(tFile.readByteBuffer());
}
if (k != numOfFiles - 1) {
Assert.assertTrue(tFile.isInMemory());
Assert.assertFalse(tFile.isInMemory());
}
}