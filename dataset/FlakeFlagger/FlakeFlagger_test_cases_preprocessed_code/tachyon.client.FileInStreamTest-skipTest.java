/** 
 * Test <code>long skip(long len)</code>.
 */
@Test public void skipTest() throws IOException {
Assert.assertTrue(is instanceof FileInStream);
Assert.assertEquals(k / 2,is.skip(k / 2));
Assert.assertEquals(k / 2,is.read());
Assert.assertTrue(is instanceof FileInStream);
Assert.assertEquals(k / 3,is.skip(k / 3));
Assert.assertEquals(k / 3,is.read());
}