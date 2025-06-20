@Test public void testDefaultEntityEnclosingRequestConstructors(){
Assert.assertNotNull(request.getProtocolVersion());
Assert.assertEquals("GET",request.getRequestLine().getMethod());
Assert.assertEquals("/",request.getRequestLine().getUri());
Assert.assertEquals(HttpVersion.HTTP_1_0,request.getProtocolVersion());
Assert.assertEquals("GET",request.getRequestLine().getMethod());
Assert.assertEquals("/",request.getRequestLine().getUri());
}