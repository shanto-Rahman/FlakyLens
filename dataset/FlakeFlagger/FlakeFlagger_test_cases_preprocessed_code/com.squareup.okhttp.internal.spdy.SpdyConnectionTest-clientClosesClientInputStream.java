/** 
 * Test that the client sends a RST_STREAM if doing so won't disrupt the output stream.
 */
@Test public void clientClosesClientInputStream() throws Exception {
fail();
assertEquals("stream closed",expected.getMessage());
fail();
assertEquals("stream finished",expected.getMessage());
assertEquals(0,connection.openStreamCount());
assertEquals(TYPE_HEADERS,synStream.type);
assertEquals(HeadersMode.SPDY_SYN_STREAM,synStream.headersMode);
assertTrue(synStream.inFinished);
assertFalse(synStream.outFinished);
assertEquals(TYPE_RST_STREAM,rstStream.type);
assertEquals(CANCEL,rstStream.errorCode);
}