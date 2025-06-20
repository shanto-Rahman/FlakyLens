/** 
 * Test <code>void read(byte[] b, int off, int len)</code>.
 */
@Test public void readTest3() throws IOException {
Assert.assertTrue(is instanceof FileInStream);
Assert.assertEquals(k / 2,is.read(ret,0,k / 2));
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k / 2,ret));
Assert.assertTrue(is instanceof FileInStream);
Assert.assertEquals(k,is.read(ret,0,k));
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
}