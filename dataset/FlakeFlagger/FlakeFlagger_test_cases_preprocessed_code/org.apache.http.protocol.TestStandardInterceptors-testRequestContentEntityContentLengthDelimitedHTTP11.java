@Test public void testRequestContentEntityContentLengthDelimitedHTTP11() throws Exception {
Assert.assertNotNull(header);
Assert.assertEquals(s.length(),Integer.parseInt(header.getValue()));
Assert.assertNull(request.getFirstHeader(HTTP.TRANSFER_ENCODING));
}