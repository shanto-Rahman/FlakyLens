@Test public void testDefaultResponseConstructors(){
Assert.assertNotNull(response.getProtocolVersion());
Assert.assertEquals(HttpVersion.HTTP_1_0,response.getProtocolVersion());
Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatusLine().getStatusCode());
Assert.assertNotNull(response.getProtocolVersion());
Assert.assertEquals(HttpVersion.HTTP_1_1,response.getProtocolVersion());
Assert.assertEquals(HttpStatus.SC_INTERNAL_SERVER_ERROR,response.getStatusLine().getStatusCode());
Assert.assertEquals("whatever",response.getStatusLine().getReasonPhrase());
}