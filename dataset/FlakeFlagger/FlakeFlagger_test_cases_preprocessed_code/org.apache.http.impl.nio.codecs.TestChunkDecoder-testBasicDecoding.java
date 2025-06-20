@Test public void testBasicDecoding() throws Exception {
Assert.assertEquals(16,bytesRead);
Assert.assertEquals("0123456789abcdef",convert(dst));
Assert.assertEquals(0,footers.length);
Assert.assertEquals(-1,bytesRead);
Assert.assertTrue(decoder.isCompleted());
}