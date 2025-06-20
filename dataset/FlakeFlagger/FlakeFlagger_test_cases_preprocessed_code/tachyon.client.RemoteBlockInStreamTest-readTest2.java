/** 
 * Test <code>void read(byte b[])</code>. Read from underfs.
 */
@Test public void readTest2() throws IOException {
if (k == 0) {
Assert.assertTrue(is instanceof EmptyBlockInStream);
Assert.assertTrue(is instanceof RemoteBlockInStream);
}
Assert.assertEquals(k,is.read(ret));
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
if (k == 0) {
Assert.assertTrue(file.isInMemory());
Assert.assertFalse(file.isInMemory());
}
if (k == 0) {
Assert.assertTrue(is instanceof EmptyBlockInStream);
Assert.assertTrue(is instanceof RemoteBlockInStream);
}
Assert.assertEquals(k,is.read(ret));
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