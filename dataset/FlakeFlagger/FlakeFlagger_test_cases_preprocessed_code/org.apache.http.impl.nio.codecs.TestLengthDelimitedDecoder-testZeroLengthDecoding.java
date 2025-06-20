@Test public void testZeroLengthDecoding() throws Exception {
Assert.assertEquals(-1,bytesRead);
Assert.assertTrue(decoder.isCompleted());
Assert.assertEquals(0,metrics.getBytesTransferred());
}