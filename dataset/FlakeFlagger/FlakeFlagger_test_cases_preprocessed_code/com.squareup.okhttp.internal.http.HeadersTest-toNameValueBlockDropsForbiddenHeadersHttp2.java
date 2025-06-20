@Test public void toNameValueBlockDropsForbiddenHeadersHttp2(){
assertEquals(expected,SpdyTransport.writeNameValueBlock(request,Protocol.HTTP_2,"HTTP/1.1"));
}