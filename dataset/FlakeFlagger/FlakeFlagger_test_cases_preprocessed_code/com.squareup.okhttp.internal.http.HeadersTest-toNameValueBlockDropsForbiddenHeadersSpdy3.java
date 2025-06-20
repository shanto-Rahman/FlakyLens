@Test public void toNameValueBlockDropsForbiddenHeadersSpdy3(){
assertEquals(expected,SpdyTransport.writeNameValueBlock(request,Protocol.SPDY_3,"HTTP/1.1"));
}