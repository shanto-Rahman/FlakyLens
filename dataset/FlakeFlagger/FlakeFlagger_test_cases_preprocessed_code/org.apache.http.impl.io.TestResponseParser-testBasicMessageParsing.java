@Test public void testBasicMessageParsing() throws Exception {
Assert.assertNotNull(statusline);
Assert.assertEquals(200,statusline.getStatusCode());
Assert.assertEquals("OK",statusline.getReasonPhrase());
Assert.assertEquals(HttpVersion.HTTP_1_1,statusline.getProtocolVersion());
Assert.assertEquals(3,headers.length);
}