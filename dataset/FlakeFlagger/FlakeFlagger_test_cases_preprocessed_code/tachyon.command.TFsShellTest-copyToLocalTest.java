@Test public void copyToLocalTest() throws IOException {
Assert.assertEquals(getCommandOutput(new String[]{"copyToLocal","/testFile",mLocalTachyonCluster.getTachyonHome() + "/testFile"}),mOutput.toString());
File testFile=new File(mLocalTachyonCluster.getTachyonHome() + "/testFile");//RO
FileInputStream fis=new FileInputStream(testFile);
Assert.assertTrue(TestUtils.equalIncreasingByteArray(10,read));
}