@Test public void testReadingWitSmallBuffer() throws Exception {
if (i > 0) {
}
Assert.assertEquals(80,bytesRead);
Assert.assertEquals("12345678901234561234567890123456" + "12345678901234561234567890123456" + "1234567890123456",convert(dst));
Assert.assertTrue(decoder.isCompleted());
}