@Test public void testDirectByteBufferAllocator(){
Assert.assertNotNull(buffer);
Assert.assertTrue(buffer.isDirect());
Assert.assertEquals(0,buffer.position());
Assert.assertEquals(1,buffer.limit());
Assert.assertEquals(1,buffer.capacity());
Assert.assertTrue(buffer.isDirect());
Assert.assertEquals(0,buffer.position());
Assert.assertEquals(2048,buffer.limit());
Assert.assertEquals(2048,buffer.capacity());
Assert.assertTrue(buffer.isDirect());
Assert.assertEquals(0,buffer.position());
Assert.assertEquals(0,buffer.limit());
Assert.assertEquals(0,buffer.capacity());
}