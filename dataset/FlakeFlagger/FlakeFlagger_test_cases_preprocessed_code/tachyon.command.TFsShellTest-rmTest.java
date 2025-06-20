@Test public void rmTest() throws IOException {
Assert.assertNotNull(mTfs.getFile("/testFolder1"));
Assert.assertNotNull(mTfs.getFile("/testFolder1/testFolder2"));
Assert.assertNotNull(mTfs.getFile("/testFolder1/testFolder2/testFile2"));
Assert.assertEquals(toCompare.toString(),mOutput.toString());
Assert.assertNotNull(mTfs.getFile("/testFolder1"));
Assert.assertNotNull(mTfs.getFile("/testFolder1/testFolder2"));
Assert.assertNull(mTfs.getFile("/testFolder1/testFolder2/testFile2"));
Assert.assertEquals(toCompare.toString(),mOutput.toString());
Assert.assertNull(mTfs.getFile("/testFolder1"));
Assert.assertNull(mTfs.getFile("/testFolder1/testFolder2"));
Assert.assertNull(mTfs.getFile("/testFolder1/testFolder2/testFile2"));
}