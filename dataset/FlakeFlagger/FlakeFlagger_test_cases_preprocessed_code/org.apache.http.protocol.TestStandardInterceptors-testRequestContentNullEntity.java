@Test public void testRequestContentNullEntity() throws Exception {
Assert.assertNotNull(header);
Assert.assertEquals("0",header.getValue());
Assert.assertNull(request.getFirstHeader(HTTP.TRANSFER_ENCODING));
}