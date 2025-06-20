@Test public void testChunkExceed() throws Exception {
Assert.assertEquals(4,encoder.write(src));
Assert.assertTrue(src.hasRemaining());
Assert.assertEquals(12,src.remaining());
Assert.assertEquals(4,encoder.write(src));
Assert.assertTrue(src.hasRemaining());
Assert.assertEquals(8,src.remaining());
Assert.assertEquals(4,encoder.write(src));
Assert.assertEquals(4,encoder.write(src));
Assert.assertFalse(src.hasRemaining());
Assert.assertEquals("4\r\n0123\r\n4\r\n4567\r\n4\r\n89AB\r\n4\r\nCDEF\r\n",s);
}