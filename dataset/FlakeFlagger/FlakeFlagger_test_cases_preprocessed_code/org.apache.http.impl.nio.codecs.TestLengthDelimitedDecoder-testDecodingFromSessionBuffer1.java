@Test public void testDecodingFromSessionBuffer1() throws Exception {
Assert.assertEquals(6,inbuf.length());
Assert.assertEquals(6,bytesRead);
Assert.assertEquals("stuff;",convert(dst));
Assert.assertFalse(decoder.isCompleted());
Assert.assertEquals(0,metrics.getBytesTransferred());
Assert.assertEquals(10,bytesRead);
Assert.assertEquals("more stuff",convert(dst));
Assert.assertTrue(decoder.isCompleted());
Assert.assertEquals(10,metrics.getBytesTransferred());
Assert.assertEquals(-1,bytesRead);
Assert.assertTrue(decoder.isCompleted());
Assert.assertEquals(10,metrics.getBytesTransferred());
}