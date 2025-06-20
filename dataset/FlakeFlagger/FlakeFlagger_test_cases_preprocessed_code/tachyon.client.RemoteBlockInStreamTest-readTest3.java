/** 
 * Test <code>void read(byte[] b, int off, int len)</code>. Read from underfs.
 */
@Test public void readTest3() throws IOException {
if (k == 0) {
Assert.assertTrue(is instanceof EmptyBlockInStream);
Assert.assertTrue(is instanceof RemoteBlockInStream);
}
Assert.assertEquals(k / 2,is.read(ret,0,k / 2));
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k / 2,ret));
if (k == 0) {
Assert.assertTrue(file.isInMemory());
Assert.assertFalse(file.isInMemory());
}
if (k == 0) {
Assert.assertTrue(is instanceof EmptyBlockInStream);
Assert.assertTrue(is instanceof RemoteBlockInStream);
}
Assert.assertEquals(k,is.read(ret,0,k));
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
Assert.assertTrue(file.isInMemory());
if (k == 0) {
Assert.assertTrue(is instanceof EmptyBlockInStream);
Assert.assertTrue(is instanceof LocalBlockInStream);
}
Assert.assertEquals(k,is.read(ret));
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
Assert.assertTrue(file.isInMemory());
}