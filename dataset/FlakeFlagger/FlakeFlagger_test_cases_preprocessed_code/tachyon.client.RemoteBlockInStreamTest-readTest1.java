/** 
 * Test <code>void read()</code>. Read from underfs.
 */
@Test public void readTest1() throws IOException {
if (k == 0) {
Assert.assertTrue(is instanceof EmptyBlockInStream);
Assert.assertTrue(is instanceof RemoteBlockInStream);
}
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
if (k == 0) {
Assert.assertTrue(file.isInMemory());
Assert.assertFalse(file.isInMemory());
}
if (k == 0) {
Assert.assertTrue(is instanceof EmptyBlockInStream);
Assert.assertTrue(is instanceof RemoteBlockInStream);
}
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
Assert.assertTrue(file.isInMemory());
if (k == 0) {
Assert.assertTrue(is instanceof EmptyBlockInStream);
Assert.assertTrue(is instanceof LocalBlockInStream);
}
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
Assert.assertTrue(file.isInMemory());
}