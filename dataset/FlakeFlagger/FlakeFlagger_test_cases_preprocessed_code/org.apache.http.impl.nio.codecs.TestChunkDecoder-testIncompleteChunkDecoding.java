@Test public void testIncompleteChunkDecoding() throws Exception {
if (i > 0) {
}
Assert.assertEquals(27,bytesRead);
Assert.assertEquals("123456789012345612345abcdef",convert(dst));
Assert.assertTrue(decoder.isCompleted());
Assert.assertEquals(2,footers.length);
Assert.assertEquals("Footer1",footers[0].getName());
Assert.assertEquals("abcde",footers[0].getValue());
Assert.assertEquals("Footer2",footers[1].getName());
Assert.assertEquals("fghij",footers[1].getValue());
Assert.assertEquals(-1,bytesRead);
Assert.assertTrue(decoder.isCompleted());
}