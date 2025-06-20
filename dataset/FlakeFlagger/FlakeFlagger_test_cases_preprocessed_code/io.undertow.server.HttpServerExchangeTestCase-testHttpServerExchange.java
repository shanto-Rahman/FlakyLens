@Test public void testHttpServerExchange() throws IOException {
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("localhost:HTTP/1.1:GET:7777:/somepath:/somepath:",HttpClientUtils.readResponse(result));
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("localhost:HTTP/1.1:GET:7777:/somepath:/somepath:a=b",HttpClientUtils.readResponse(result));
}