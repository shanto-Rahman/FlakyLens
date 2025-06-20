@Test public void testSetResponseStatus(){
Assert.assertNotNull(response.getProtocolVersion());
Assert.assertNotNull(response.getStatusLine());
Assert.assertEquals(200,response.getStatusLine().getStatusCode());
Assert.assertNotNull(response.getProtocolVersion());
Assert.assertEquals(HttpVersion.HTTP_1_0,response.getProtocolVersion());
Assert.assertEquals(HttpStatus.SC_BAD_REQUEST,response.getStatusLine().getStatusCode());
Assert.assertNotNull(response.getProtocolVersion());
Assert.assertEquals(HttpVersion.HTTP_1_1,response.getProtocolVersion());
Assert.assertEquals(HttpStatus.SC_INTERNAL_SERVER_ERROR,response.getStatusLine().getStatusCode());
Assert.assertEquals("whatever",response.getStatusLine().getReasonPhrase());
Assert.fail("IllegalArgumentException should have been thrown");
Assert.fail("IllegalArgumentException should have been thrown");
Assert.fail("IllegalArgumentException should have been thrown");
}