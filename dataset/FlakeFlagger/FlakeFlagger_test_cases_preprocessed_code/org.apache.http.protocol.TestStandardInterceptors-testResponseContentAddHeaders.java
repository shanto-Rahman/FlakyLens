@Test public void testResponseContentAddHeaders() throws Exception {
Assert.assertEquals("0",response.getFirstHeader(HTTP.CONTENT_LEN).getValue());
Assert.assertNull(response.getFirstHeader(HTTP.TRANSFER_ENCODING));
}