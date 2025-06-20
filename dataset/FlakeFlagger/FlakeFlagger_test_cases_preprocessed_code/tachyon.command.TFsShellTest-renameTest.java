@Test public void renameTest() throws IOException {
Assert.assertNotNull(mTfs.getFile("/testFolder1"));
Assert.assertEquals(toCompare.toString(),mOutput.toString());
Assert.assertNotNull(mTfs.getFile("/testFolder"));
Assert.assertNull(mTfs.getFile("/testFolder1"));
}