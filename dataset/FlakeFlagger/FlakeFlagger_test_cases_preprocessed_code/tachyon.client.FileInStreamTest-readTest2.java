/** 
 * Test <code>void read(byte b[])</code>.
 */
@Test public void readTest2() throws IOException {
Assert.assertTrue(is instanceof FileInStream);
Assert.assertEquals(k,is.read(ret));
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
Assert.assertTrue(is instanceof FileInStream);
Assert.assertEquals(k,is.read(ret));
Assert.assertTrue(TestUtils.equalIncreasingByteArray(k,ret));
}