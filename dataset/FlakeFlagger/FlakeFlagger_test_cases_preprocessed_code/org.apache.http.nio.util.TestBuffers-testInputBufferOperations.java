@Test public void testInputBufferOperations() throws IOException {
Assert.assertEquals(16,count);
Assert.assertTrue(decoder.isCompleted());
Assert.assertEquals("stuff",EncodingUtils.getAsciiString(b1,0,len));
Assert.assertEquals(';',c);
Assert.assertEquals("more stuff",EncodingUtils.getAsciiString(b2,0,len));
Assert.assertEquals(-1,buffer.read());
Assert.assertEquals(-1,buffer.read(b2));
Assert.assertEquals(-1,buffer.read(b2,0,b2.length));
Assert.assertTrue(buffer.isEndOfStream());
Assert.assertFalse(buffer.isEndOfStream());
}