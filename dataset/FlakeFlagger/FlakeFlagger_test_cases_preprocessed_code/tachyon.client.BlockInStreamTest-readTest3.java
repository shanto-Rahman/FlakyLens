/** 
 * Test <code>void read(byte[] b, int off, int len)</code>.
 */
@Test public void readTest3() throws IOException {
if (k == 0) {
Assert.assertTrue(is instanceof EmptyBlockInStream);
Assert.assertTrue(is instanceof BlockInStream);
}
Assert.assertEquals(k / 2,is.read(ret,0,k / 2));
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k / 2,ret));
if (k == 0) {
Assert.assertTrue(is instanceof EmptyBlockInStream);
Assert.assertTrue(is instanceof BlockInStream);
}
Assert.assertEquals(k,is.read(ret,0,k));
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
}