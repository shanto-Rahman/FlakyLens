@Test public void copyFromLocalTest() throws IOException {
File testFile=new File(mLocalTachyonCluster.getTachyonHome() + "/testFile");//RO
FileOutputStream fos=new FileOutputStream(testFile);
Assert.assertEquals(getCommandOutput(new String[]{"copyFromLocal",testFile.getAbsolutePath(),"/testFile"}),mOutput.toString());
Assert.assertNotNull(tFile);
Assert.assertEquals(10,tFile.length());
Assert.assertTrue(TestUtils.equalIncreasingByteArray(10,read));
}