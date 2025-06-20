@Test public void testBasicBufferProperties() throws Exception {
Assert.assertEquals(SessionInputBufferMock.BUFFER_SIZE,inbuffer.capacity());
Assert.assertEquals(SessionInputBufferMock.BUFFER_SIZE,inbuffer.available());
Assert.assertEquals(0,inbuffer.length());
Assert.assertEquals(SessionInputBufferMock.BUFFER_SIZE - 2,inbuffer.available());
Assert.assertEquals(2,inbuffer.length());
Assert.assertEquals(SessionOutputBufferMock.BUFFER_SIZE,outbuffer.capacity());
Assert.assertEquals(SessionOutputBufferMock.BUFFER_SIZE,outbuffer.available());
Assert.assertEquals(0,outbuffer.length());
Assert.assertEquals(SessionOutputBufferMock.BUFFER_SIZE - 3,outbuffer.available());
Assert.assertEquals(3,outbuffer.length());
}