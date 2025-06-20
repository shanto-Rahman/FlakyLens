@Test public void testSLParseSuccess() throws Exception {
Assert.assertEquals("HTTP/1.1 200 OK",statusLine.toString());
Assert.assertEquals(HttpVersion.HTTP_1_1,statusLine.getProtocolVersion());
Assert.assertEquals(200,statusLine.getStatusCode());
Assert.assertEquals("OK",statusLine.getReasonPhrase());
Assert.assertEquals(404,statusLine.getStatusCode());
Assert.assertEquals("Not Found",statusLine.getReasonPhrase());
Assert.assertEquals("Non Trouve",statusLine.getReasonPhrase());
Assert.assertEquals("Not Found",statusLine.getReasonPhrase());
Assert.assertEquals(200,statusLine.getStatusCode());
Assert.assertEquals("",statusLine.getReasonPhrase());
Assert.assertEquals(200,statusLine.getStatusCode());
Assert.assertEquals("",statusLine.getReasonPhrase());
Assert.assertEquals(200,statusLine.getStatusCode());
Assert.assertEquals("OK",statusLine.getReasonPhrase());
Assert.assertEquals(200,statusLine.getStatusCode());
Assert.assertEquals("OK",statusLine.getReasonPhrase());
Assert.assertEquals(HttpVersion.HTTP_1_1,statusLine.getProtocolVersion());
Assert.assertEquals(200,statusLine.getStatusCode());
Assert.assertEquals("OK",statusLine.getReasonPhrase());
Assert.assertEquals(HttpVersion.HTTP_1_1,statusLine.getProtocolVersion());
}