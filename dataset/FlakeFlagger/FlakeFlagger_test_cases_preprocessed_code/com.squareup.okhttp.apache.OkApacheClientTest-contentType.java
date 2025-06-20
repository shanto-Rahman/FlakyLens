@Test public void contentType() throws Exception {
assertEquals(1,headers1.length);
assertEquals("text/html",headers1[0].getValue());
assertNotNull(response1.getEntity().getContentType());
assertEquals("text/html",response1.getEntity().getContentType().getValue());
assertEquals(1,headers2.length);
assertEquals("application/json",headers2[0].getValue());
assertNotNull(response2.getEntity().getContentType());
assertEquals("application/json",response2.getEntity().getContentType().getValue());
assertEquals(0,headers3.length);
assertNull(response3.getEntity().getContentType());
}