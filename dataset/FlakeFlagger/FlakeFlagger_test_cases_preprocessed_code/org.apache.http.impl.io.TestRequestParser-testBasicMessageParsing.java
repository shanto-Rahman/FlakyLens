@Test public void testBasicMessageParsing() throws Exception {
Assert.assertNotNull(reqline);
Assert.assertEquals("GET",reqline.getMethod());
Assert.assertEquals("/",reqline.getUri());
Assert.assertEquals(HttpVersion.HTTP_1_1,reqline.getProtocolVersion());
Assert.assertEquals(3,headers.length);
}