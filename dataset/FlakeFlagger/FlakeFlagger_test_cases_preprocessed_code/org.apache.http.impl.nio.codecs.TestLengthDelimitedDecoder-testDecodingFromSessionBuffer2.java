@Test public void testDecodingFromSessionBuffer2() throws Exception {
Assert.assertEquals(38,inbuf.length());
Assert.assertEquals(16,bytesRead);
Assert.assertEquals("stuff;more stuff",convert(dst));
Assert.assertTrue(decoder.isCompleted());
Assert.assertEquals(0,metrics.getBytesTransferred());
Assert.assertEquals(-1,bytesRead);
Assert.assertTrue(decoder.isCompleted());
Assert.assertEquals(0,metrics.getBytesTransferred());
}