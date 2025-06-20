@Test public void testChunkedInputStreamNoClosingChunk() throws IOException {
Assert.assertEquals(5,in.read(tmp));
Assert.assertEquals(-1,in.read());
}