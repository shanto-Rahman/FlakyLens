/** 
 * Test <code>long skip(long len)</code>.
 */
@Test public void skipTest() throws IOException {
Assert.assertTrue(is instanceof RemoteBlockInStream);
Assert.assertEquals(k / 2,is.skip(k / 2));
Assert.assertEquals(k / 2,is.read());
Assert.assertFalse(file.isInMemory());
if (k >= 3) {
Assert.assertTrue(is instanceof RemoteBlockInStream);
Assert.assertEquals(t,is.skip(t));
Assert.assertEquals(t,is.read());
Assert.assertEquals(t,is.skip(t));
Assert.assertEquals(2 * t + 1,is.read());
Assert.assertFalse(file.isInMemory());
}
}