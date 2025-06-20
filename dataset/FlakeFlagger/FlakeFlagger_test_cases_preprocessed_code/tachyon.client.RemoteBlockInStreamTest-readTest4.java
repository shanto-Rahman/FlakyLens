/** 
 * Test <code>void read()</code>. Read from remote data server.
 */
@Test public void readTest4() throws IOException {
Assert.assertTrue(is instanceof RemoteBlockInStream);
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
Assert.assertTrue(file.isInMemory());
}