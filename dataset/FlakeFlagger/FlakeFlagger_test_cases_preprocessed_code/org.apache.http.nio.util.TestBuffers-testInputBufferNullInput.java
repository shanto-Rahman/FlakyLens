@Test public void testInputBufferNullInput() throws IOException {
Assert.assertEquals(0,buffer.read(null));
Assert.assertEquals(0,buffer.read(null,0,0));
}