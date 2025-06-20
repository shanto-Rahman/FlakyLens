@Test public void contentEncoding() throws Exception {
assertEquals(1,headers1.length);
assertEquals("gzip",headers1[0].getValue());
assertNotNull(response1.getEntity().getContentEncoding());
assertEquals("gzip",response1.getEntity().getContentEncoding().getValue());
assertEquals(text,decodedContent);
}