/** 
 * Test <code>long skip(long len)</code>.
 */
@Test public void skipTest() throws IOException {
Assert.assertTrue(is instanceof LocalBlockInStream);
Assert.assertEquals(k / 2,is.skip(k / 2));
Assert.assertEquals(k / 2,is.read());
Assert.assertTrue(file.isInMemory());
Assert.assertTrue(is instanceof LocalBlockInStream);
Assert.assertEquals(t,is.skip(t));
Assert.assertEquals(t,is.read());
Assert.assertEquals(t,is.skip(t));
Assert.assertEquals(2 * t + 1,is.read());
Assert.assertTrue(file.isInMemory());
}