@Test public void testCodingFromFileSmaller() throws Exception {
FileOutputStream fout=new FileOutputStream(tmpFile);
FileChannel fchannel=new FileInputStream(tmpFile).getChannel();
Assert.assertTrue(encoder.isCompleted());
Assert.assertEquals("stuff;more stuff",s);
}