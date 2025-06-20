@Test public void testDefaultRequestConstructors(){
Assert.assertNotNull(request.getProtocolVersion());
Assert.assertEquals("WHATEVER",request.getRequestLine().getMethod());
Assert.assertEquals("/",request.getRequestLine().getUri());
Assert.assertEquals(HttpVersion.HTTP_1_0,request.getProtocolVersion());
Assert.assertEquals("GET",request.getRequestLine().getMethod());
Assert.assertEquals("/",request.getRequestLine().getUri());
Assert.fail("IllegalArgumentException should have been thrown");
Assert.fail("IllegalArgumentException should have been thrown");
Assert.fail("IllegalArgumentException should have been thrown");
}