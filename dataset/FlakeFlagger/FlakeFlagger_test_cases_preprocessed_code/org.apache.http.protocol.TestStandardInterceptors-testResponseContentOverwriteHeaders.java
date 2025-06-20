@Test public void testResponseContentOverwriteHeaders() throws Exception {
Assert.assertEquals("0",response.getFirstHeader(HTTP.CONTENT_LEN).getValue());
Assert.assertEquals("whatever",response.getFirstHeader(HTTP.TRANSFER_ENCODING).getValue());
}