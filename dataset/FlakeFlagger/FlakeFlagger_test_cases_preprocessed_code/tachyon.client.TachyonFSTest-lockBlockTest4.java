@Test public void lockBlockTest4() throws IOException {
Assert.assertFalse(tFile.isInMemory());
if (k < numOfFiles) {
Assert.assertNull(tFile.readByteBuffer());
Assert.assertTrue(tFile.recache());
Assert.assertNotNull(tFile.readByteBuffer());
Assert.assertNull(tFile.readByteBuffer());
Assert.assertFalse(tFile.recache());
Assert.assertNull(tFile.readByteBuffer());
}
}