@Test public void testHeapByteBufferAllocator(){
Assert.assertNotNull(buffer);
Assert.assertFalse(buffer.isDirect());
Assert.assertEquals(0,buffer.position());
Assert.assertEquals(1,buffer.limit());
Assert.assertEquals(1,buffer.capacity());
Assert.assertFalse(buffer.isDirect());
Assert.assertEquals(0,buffer.position());
Assert.assertEquals(2048,buffer.limit());
Assert.assertEquals(2048,buffer.capacity());
Assert.assertFalse(buffer.isDirect());
Assert.assertEquals(0,buffer.position());
Assert.assertEquals(0,buffer.limit());
Assert.assertEquals(0,buffer.capacity());
}