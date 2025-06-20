/** 
 * Test <code>void read(byte[] b, int off, int len)</code>. Read from remote data server.
 */
@Test public void readTest6() throws IOException {
Assert.assertTrue(is instanceof RemoteBlockInStream);
Assert.assertTrue(TestUtils.equalIncreasingByteArray(start,read,ret));
Assert.assertTrue(file.isInMemory());
}