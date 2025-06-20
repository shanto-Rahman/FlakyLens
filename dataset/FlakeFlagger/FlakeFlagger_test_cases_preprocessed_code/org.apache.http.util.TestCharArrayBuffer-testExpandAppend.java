@Test public void testExpandAppend() throws Exception {
Assert.assertEquals(4,buffer.capacity());
Assert.assertEquals(8,buffer.capacity());
Assert.assertEquals(6,buffer.length());
Assert.assertEquals(16,buffer.capacity());
Assert.assertEquals(10,buffer.length());
Assert.assertEquals("1212341234",buffer.toString());
}