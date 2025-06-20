@Test public void testContentType() throws Exception {
Assert.assertEquals(HTTP.CONTENT_TYPE,httpentity.getContentType().getName());
Assert.assertEquals(HTTP.PLAIN_TEXT_TYPE,httpentity.getContentType().getValue());
Assert.assertEquals(HTTP.CONTENT_TYPE,httpentity.getContentType().getName());
Assert.assertEquals(HTTP.PLAIN_TEXT_TYPE,httpentity.getContentType().getValue());
Assert.assertNull(httpentity.getContentType());
Assert.assertNull(httpentity.getContentType());
}