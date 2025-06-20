/** 
 * Test <code>void read(byte b[])</code>. Read from underfs.
 */
@Test public void readTest7() throws IOException {
if (k == 0) {
Assert.assertTrue(is instanceof EmptyBlockInStream);
Assert.assertTrue(is instanceof RemoteBlockInStream);
}
Assert.assertEquals(k,is.read(ret));
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
Assert.assertEquals(-1,is.read(ret));
Assert.assertFalse(file.isInMemory());
}