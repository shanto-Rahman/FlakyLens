@Test public void testCodingCompletedFromFile() throws Exception {
FileOutputStream fout=new FileOutputStream(tmpFile);
FileChannel fchannel=new FileInputStream(tmpFile).getChannel();
Assert.fail("IllegalStateException should have been thrown");
}