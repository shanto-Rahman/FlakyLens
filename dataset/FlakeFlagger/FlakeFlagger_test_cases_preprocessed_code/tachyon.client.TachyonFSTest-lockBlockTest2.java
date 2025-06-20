@Test public void lockBlockTest2() throws IOException {
Assert.assertTrue(tFile.isInMemory());
Assert.assertNotNull(tFile.readByteBuffer());
Assert.assertTrue(tFile.isInMemory());
Assert.assertFalse(tFile.isInMemory());
}