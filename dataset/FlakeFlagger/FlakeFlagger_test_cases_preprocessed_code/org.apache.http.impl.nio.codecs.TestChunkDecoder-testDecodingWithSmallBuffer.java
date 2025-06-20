@Test public void testDecodingWithSmallBuffer() throws Exception {
if (i > 0) {
}
Assert.assertEquals(16,bytesRead);
Assert.assertEquals("0123456789abcdef",convert(dst));
Assert.assertTrue(decoder.isCompleted());
Assert.assertEquals(-1,bytesRead);
Assert.assertTrue(decoder.isCompleted());
}