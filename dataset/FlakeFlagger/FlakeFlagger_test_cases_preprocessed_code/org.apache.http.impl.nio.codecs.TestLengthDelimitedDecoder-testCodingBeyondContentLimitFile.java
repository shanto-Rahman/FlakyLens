@Test public void testCodingBeyondContentLimitFile() throws Exception {
Assert.assertEquals(6,bytesRead);
Assert.assertFalse(decoder.isCompleted());
Assert.assertEquals(6,metrics.getBytesTransferred());
Assert.assertEquals(10,bytesRead);
Assert.assertTrue(decoder.isCompleted());
Assert.assertEquals(16,metrics.getBytesTransferred());
Assert.assertEquals(-1,bytesRead);
Assert.assertTrue(decoder.isCompleted());
Assert.assertEquals(16,metrics.getBytesTransferred());
}