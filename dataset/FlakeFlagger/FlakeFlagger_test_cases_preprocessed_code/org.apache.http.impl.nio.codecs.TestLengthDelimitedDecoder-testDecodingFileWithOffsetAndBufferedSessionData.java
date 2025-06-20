@Test public void testDecodingFileWithOffsetAndBufferedSessionData() throws Exception {
Assert.assertEquals(7,i);
if (testfile.length() < pos) testfile.setLength(pos);
if (bytesRead > 0) {
}
Assert.assertEquals(this.tmpfile.length() - 7 - beginning.length,metrics.getBytesTransferred());
Assert.assertEquals("beginning; stuff; more stuff; a lot more stuff!",readFromFile(this.tmpfile));
}