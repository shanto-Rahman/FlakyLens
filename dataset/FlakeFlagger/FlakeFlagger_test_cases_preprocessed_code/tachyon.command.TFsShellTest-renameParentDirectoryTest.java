@Test public void renameParentDirectoryTest() throws IOException {
Assert.assertNotNull(mTfs.getFile("/test2/File1"));
Assert.assertNull(mTfs.getFile("/test"));
Assert.assertNull(mTfs.getFile("/test/File1"));
Assert.assertEquals(toCompare.toString(),mOutput.toString());
}