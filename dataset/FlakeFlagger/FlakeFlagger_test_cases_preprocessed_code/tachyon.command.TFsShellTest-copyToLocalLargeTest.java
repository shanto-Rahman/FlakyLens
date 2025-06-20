@Test public void copyToLocalLargeTest() throws IOException {
Assert.assertEquals(getCommandOutput(new String[]{"copyToLocal","/testFile",mLocalTachyonCluster.getTachyonHome() + "/testFile"}),mOutput.toString());
File testFile=new File(mLocalTachyonCluster.getTachyonHome() + "/testFile");//RO
FileInputStream fis=new FileInputStream(testFile);
Assert.assertTrue(TestUtils.equalIncreasingByteArray(mSizeBytes,read));
}