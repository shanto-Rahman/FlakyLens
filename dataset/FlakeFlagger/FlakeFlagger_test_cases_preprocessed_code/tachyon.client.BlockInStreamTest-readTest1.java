/** 
 * Test <code>void read()</code>.
 */
@Test public void readTest1() throws IOException {
if (k == 0) {
Assert.assertTrue(is instanceof EmptyBlockInStream);
Assert.assertTrue(is instanceof BlockInStream);
}
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
if (k == 0) {
Assert.assertTrue(is instanceof EmptyBlockInStream);
Assert.assertTrue(is instanceof BlockInStream);
}
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
}