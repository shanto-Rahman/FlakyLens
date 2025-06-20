@Test public void jsonTransparentGzipResponse() throws Exception {
assertEquals(0,headers1a.length);
assertNull(response1.getEntity().getContentEncoding());
assertEquals(0,headers1b.length);
assertTrue(response1.getEntity().getContentLength() < 0);
assertEquals(1,headers1c.length);
assertEquals("application/json",headers1c[0].getValue());
assertNotNull(response1.getEntity().getContentType());
assertEquals("application/json",response1.getEntity().getContentType().getValue());
assertEquals(text,decodedContent);
}