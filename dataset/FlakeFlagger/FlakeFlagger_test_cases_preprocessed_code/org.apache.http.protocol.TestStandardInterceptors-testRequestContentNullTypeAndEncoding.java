@Test public void testRequestContentNullTypeAndEncoding() throws Exception {
Assert.assertNull(request.getFirstHeader(HTTP.CONTENT_TYPE));
Assert.assertNull(request.getFirstHeader(HTTP.CONTENT_ENCODING));
}