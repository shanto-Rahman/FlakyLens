@Test public void testBasicDecodingFile() throws Exception {
if (bytesRead > 0) {
}
Assert.assertEquals(this.tmpfile.length(),metrics.getBytesTransferred());
Assert.assertEquals("stuff; more stuff; a lot more stuff!",readFromFile(this.tmpfile));
}