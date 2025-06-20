@Test public void postBodyRetransmittedOnRedirect() throws Exception {
assertEquals("body!",request1.getUtf8Body());
assertEquals("5",request1.getHeader("Content-Length"));
assertEquals("text/plain; charset=utf-8",request1.getHeader("Content-Type"));
assertEquals(0,request1.getSequenceNumber());
assertEquals("body!",request2.getUtf8Body());
assertEquals("5",request2.getHeader("Content-Length"));
assertEquals("text/plain; charset=utf-8",request2.getHeader("Content-Type"));
assertEquals(1,request2.getSequenceNumber());
}