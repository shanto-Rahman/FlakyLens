@Test public void testChunkedInputStreamOneByteRead() throws IOException {
Assert.assertEquals(i,ch);
Assert.assertEquals(-1,in.read());
Assert.assertEquals(-1,in.read());
}