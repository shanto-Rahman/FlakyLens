@Test public void testFoldedFooters() throws Exception {
Assert.assertEquals(26,bytesRead);
Assert.assertEquals("12345678901234561234512345",convert(dst));
Assert.assertEquals(1,footers.length);
Assert.assertEquals("Footer1",footers[0].getName());
Assert.assertEquals("abcde  fghij",footers[0].getValue());
}