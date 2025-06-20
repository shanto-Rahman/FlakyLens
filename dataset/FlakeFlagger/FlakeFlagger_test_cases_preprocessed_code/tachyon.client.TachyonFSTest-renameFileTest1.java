@Test public void renameFileTest1() throws IOException {
Assert.assertTrue(mTfs.exist("/root/testFile" + k));
Assert.assertTrue(mTfs.rename("/root/testFile" + k,"/root/testFile" + (k + 1)));
Assert.assertEquals(fileId,mTfs.getFileId("/root/testFile" + (k + 1)));
Assert.assertFalse(mTfs.exist("/root/testFile" + k));
}