@Test public void testEndOfStreamConditionReadingFooters() throws Exception {
if (i > 0) {
}
Assert.assertEquals(26,bytesRead);
Assert.assertEquals("12345678901234561234512345",convert(dst));
Assert.assertTrue(decoder.isCompleted());
}