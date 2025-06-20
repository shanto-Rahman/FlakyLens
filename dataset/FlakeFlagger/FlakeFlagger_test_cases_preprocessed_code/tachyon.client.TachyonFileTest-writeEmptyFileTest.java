@Test public void writeEmptyFileTest() throws IOException {
Assert.assertEquals(2,mTfs.createFile("/emptyFile"));
Assert.assertTrue(mTfs.exist("/emptyFile"));
Assert.assertEquals(0,file.length());
Assert.assertEquals(0,file.length());
}