@Test public void testConstructor(){
Assert.assertEquals("GET",requestline.getMethod());
Assert.assertEquals("/stuff",requestline.getUri());
Assert.assertEquals(HttpVersion.HTTP_1_1,requestline.getProtocolVersion());
}