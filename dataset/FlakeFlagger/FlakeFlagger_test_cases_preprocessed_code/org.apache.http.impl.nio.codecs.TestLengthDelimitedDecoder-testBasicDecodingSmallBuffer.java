@Test public void testBasicDecodingSmallBuffer() throws Exception {
Assert.assertEquals(4,bytesRead);
Assert.assertEquals("stuf",convert(dst));
Assert.assertFalse(decoder.isCompleted());
Assert.assertEquals(4,metrics.getBytesTransferred());
Assert.assertEquals(2,bytesRead);
Assert.assertEquals("f;",convert(dst));
Assert.assertFalse(decoder.isCompleted());
Assert.assertEquals(6,metrics.getBytesTransferred());
Assert.assertEquals(4,bytesRead);
Assert.assertEquals("more",convert(dst));
Assert.assertFalse(decoder.isCompleted());
Assert.assertEquals(10,metrics.getBytesTransferred());
Assert.assertEquals(4,bytesRead);
Assert.assertEquals(" stu",convert(dst));
Assert.assertFalse(decoder.isCompleted());
Assert.assertEquals(14,metrics.getBytesTransferred());
Assert.assertEquals(2,bytesRead);
Assert.assertEquals("ff",convert(dst));
Assert.assertTrue(decoder.isCompleted());
Assert.assertEquals(16,metrics.getBytesTransferred());
Assert.assertEquals(-1,bytesRead);
Assert.assertTrue(decoder.isCompleted());
Assert.assertEquals(16,metrics.getBytesTransferred());
}