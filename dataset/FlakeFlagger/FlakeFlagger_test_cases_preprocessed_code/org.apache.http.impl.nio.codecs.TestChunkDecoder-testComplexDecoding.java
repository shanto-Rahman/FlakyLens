@Test public void testComplexDecoding() throws Exception {
if (i > 0) {
}
Assert.assertEquals(26,bytesRead);
Assert.assertEquals("12345678901234561234512345",convert(dst));
Assert.assertEquals(2,footers.length);
Assert.assertEquals("Footer1",footers[0].getName());
Assert.assertEquals("abcde",footers[0].getValue());
Assert.assertEquals("Footer2",footers[1].getName());
Assert.assertEquals("fghij",footers[1].getValue());
Assert.assertEquals(-1,bytesRead);
Assert.assertTrue(decoder.isCompleted());
}