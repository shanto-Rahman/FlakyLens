@Test public void testChunkedInputStreamLargeBuffer() throws IOException {
Assert.assertEquals(-1,in.read(buffer));
Assert.assertEquals(-1,in.read(buffer));
Assert.assertEquals(result,CHUNKED_RESULT);
Assert.assertNotNull(footers);
Assert.assertEquals(2,footers.length);
Assert.assertEquals("Footer1",footers[0].getName());
Assert.assertEquals("abcde",footers[0].getValue());
Assert.assertEquals("Footer2",footers[1].getName());
Assert.assertEquals("fghij",footers[1].getValue());
}