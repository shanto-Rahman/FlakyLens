@Test public void renameFileTest3() throws IOException {
Assert.assertTrue(mTfs.exist("/root/testFile" + (k - 1)));
Assert.assertTrue(file.rename("/root/testFile" + k));
Assert.assertEquals(fileId,mTfs.getFileId("/root/testFile" + k));
Assert.assertFalse(mTfs.exist("/root/testFile" + (k - 1)));
}