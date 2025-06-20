@Test public void testBufferInfo() throws Exception {
Assert.assertEquals(0,bufferinfo.length());
Assert.assertEquals(8,bufferinfo.available());
Assert.assertEquals(4,bufferinfo.length());
Assert.assertEquals(4,bufferinfo.available());
Assert.assertEquals(12,bufferinfo.length());
Assert.assertEquals(0,bufferinfo.available());
}