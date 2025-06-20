/** 
 * Test <code>void read()</code>.
 */
@Test public void readTest1() throws IOException {
if (k == 0) {
Assert.assertTrue(is instanceof EmptyBlockInStream);
Assert.assertTrue(is instanceof LocalBlockInStream);
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