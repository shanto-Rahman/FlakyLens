@Test public void testDecodingFileWithBufferedSessionData() throws Exception {
Assert.assertEquals(7,i);
if (bytesRead > 0) {
}
Assert.assertEquals(this.tmpfile.length() - 7,metrics.getBytesTransferred());
Assert.assertEquals("stuff; more stuff; a lot more stuff!",readFromFile(this.tmpfile));
}