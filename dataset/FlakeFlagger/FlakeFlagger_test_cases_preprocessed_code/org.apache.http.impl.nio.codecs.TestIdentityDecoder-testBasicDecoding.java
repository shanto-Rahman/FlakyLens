@Test public void testBasicDecoding() throws Exception {
Assert.assertEquals(6,bytesRead);
Assert.assertEquals("stuff;",convert(dst));
Assert.assertFalse(decoder.isCompleted());
Assert.assertEquals(6,metrics.getBytesTransferred());
Assert.assertEquals(10,bytesRead);
Assert.assertEquals("more stuff",convert(dst));
Assert.assertFalse(decoder.isCompleted());
Assert.assertEquals(16,metrics.getBytesTransferred());
Assert.assertEquals(-1,bytesRead);
Assert.assertTrue(decoder.isCompleted());
Assert.assertEquals(16,metrics.getBytesTransferred());
Assert.assertEquals(-1,bytesRead);
Assert.assertTrue(decoder.isCompleted());
Assert.assertEquals(16,metrics.getBytesTransferred());
}