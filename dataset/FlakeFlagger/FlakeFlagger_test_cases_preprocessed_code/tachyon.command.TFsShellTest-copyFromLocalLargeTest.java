@Test public void copyFromLocalLargeTest() throws IOException {
File testFile=new File(mLocalTachyonCluster.getTachyonHome() + "/testFile");//RO
FileOutputStream fos=new FileOutputStream(testFile);
Assert.assertEquals(getCommandOutput(new String[]{"copyFromLocal",testFile.getAbsolutePath(),"/testFile"}),mOutput.toString());
Assert.assertNotNull(tFile);
Assert.assertEquals(mSizeBytes,tFile.length());
Assert.assertTrue(TestUtils.equalIncreasingByteArray(mSizeBytes,read));
}