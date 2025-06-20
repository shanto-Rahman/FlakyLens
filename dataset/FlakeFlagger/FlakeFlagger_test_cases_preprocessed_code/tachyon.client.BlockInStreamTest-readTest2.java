/** 
 * Test <code>void read(byte b[])</code>.
 */
@Test public void readTest2() throws IOException {
if (k == 0) {
Assert.assertTrue(is instanceof EmptyBlockInStream);
Assert.assertTrue(is instanceof BlockInStream);
}
Assert.assertEquals(k,is.read(ret));
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
if (k == 0) {
Assert.assertTrue(is instanceof EmptyBlockInStream);
Assert.assertTrue(is instanceof BlockInStream);
}
Assert.assertEquals(k,is.read(ret));
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
}