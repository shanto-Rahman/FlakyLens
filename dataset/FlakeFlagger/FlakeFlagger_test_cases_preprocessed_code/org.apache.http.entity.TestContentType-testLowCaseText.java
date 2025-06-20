@Test public void testLowCaseText() throws Exception {
Assert.assertEquals("text/plain",contentType.getMimeType());
Assert.assertEquals("ascii",contentType.getCharset());
}