@Test public void testRequestContentEntityUnknownLengthHTTP11() throws Exception {
Assert.assertNotNull(header);
Assert.assertEquals("chunked",header.getValue());
Assert.assertNull(request.getFirstHeader(HTTP.CONTENT_LEN));
}