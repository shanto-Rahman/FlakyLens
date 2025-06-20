@Test public void testEmptyByteArray_shouldReturnNull(){
assertNull("An empty byte array should be translated to null",ser.fromByteBuffer(ByteBuffer.wrap(new byte[0])));
}