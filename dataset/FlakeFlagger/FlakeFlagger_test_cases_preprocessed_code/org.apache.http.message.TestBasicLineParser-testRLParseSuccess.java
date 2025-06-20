@Test public void testRLParseSuccess() throws Exception {
Assert.assertEquals("GET /stuff HTTP/1.1",requestline.toString());
Assert.assertEquals("GET",requestline.getMethod());
Assert.assertEquals("/stuff",requestline.getUri());
Assert.assertEquals(HttpVersion.HTTP_1_1,requestline.getProtocolVersion());
Assert.assertEquals("GET /stuff HTTP/1.1",requestline.toString());
Assert.assertEquals("GET",requestline.getMethod());
Assert.assertEquals("/stuff",requestline.getUri());
Assert.assertEquals(HttpVersion.HTTP_1_1,requestline.getProtocolVersion());
Assert.assertEquals("GET",requestline.getMethod());
Assert.assertEquals("/stuff",requestline.getUri());
Assert.assertEquals(HttpVersion.HTTP_1_1,requestline.getProtocolVersion());
}