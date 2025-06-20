@Test public void redirectToCachedResult() throws Exception {
assertEquals("ABC",readAscii(openConnection(server.getUrl("/foo"))));
assertEquals("GET /foo HTTP/1.1",request1.getRequestLine());
assertEquals(0,request1.getSequenceNumber());
assertEquals("ABC",readAscii(openConnection(server.getUrl("/bar"))));
assertEquals("GET /bar HTTP/1.1",request2.getRequestLine());
assertEquals(1,request2.getSequenceNumber());
assertEquals("DEF",readAscii(openConnection(server.getUrl("/baz"))));
assertEquals("GET /baz HTTP/1.1",request3.getRequestLine());
assertEquals(2,request3.getSequenceNumber());
}