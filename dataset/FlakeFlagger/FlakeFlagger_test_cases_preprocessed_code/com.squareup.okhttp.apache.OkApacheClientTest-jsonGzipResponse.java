@Test public void jsonGzipResponse() throws Exception {
assertEquals(1,headers1a.length);
assertEquals("gzip",headers1a[0].getValue());
assertNotNull(response1.getEntity().getContentEncoding());
assertEquals("gzip",response1.getEntity().getContentEncoding().getValue());
assertEquals(1,headers1b.length);
assertEquals("application/json",headers1b[0].getValue());
assertNotNull(response1.getEntity().getContentType());
assertEquals("application/json",response1.getEntity().getContentType().getValue());
assertEquals(text,decodedContent);
}