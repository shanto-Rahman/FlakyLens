@Test public void testConstructor(){
Assert.assertEquals(HttpVersion.HTTP_1_1,statusline.getProtocolVersion());
Assert.assertEquals(HttpStatus.SC_OK,statusline.getStatusCode());
Assert.assertEquals("OK",statusline.getReasonPhrase());
}