@Test public void testMessageParsingTimeout() throws Exception {
Assert.assertNotNull(httprequest);
Assert.assertEquals(5,timeoutCount);
Assert.assertNotNull(reqline);
Assert.assertEquals("GET",reqline.getMethod());
Assert.assertEquals("/",reqline.getUri());
Assert.assertEquals(HttpVersion.HTTP_1_1,reqline.getProtocolVersion());
Assert.assertEquals(3,headers.length);
}