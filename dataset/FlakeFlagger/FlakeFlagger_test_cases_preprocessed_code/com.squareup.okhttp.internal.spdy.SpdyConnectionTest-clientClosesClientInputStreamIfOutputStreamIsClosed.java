/** 
 * Test that the client doesn't send a RST_STREAM if doing so will disrupt the output stream.
 */
@Test public void clientClosesClientInputStreamIfOutputStreamIsClosed() throws Exception {
fail();
assertEquals("stream closed",expected.getMessage());
assertEquals(0,connection.openStreamCount());
assertEquals(TYPE_HEADERS,synStream.type);
assertEquals(HeadersMode.SPDY_SYN_STREAM,synStream.headersMode);
assertFalse(synStream.inFinished);
assertFalse(synStream.outFinished);
assertEquals(TYPE_DATA,data.type);
assertTrue(Arrays.equals("square".getBytes("UTF-8"),data.data));
assertEquals(TYPE_DATA,fin.type);
assertTrue(fin.inFinished);
assertFalse(fin.outFinished);
assertEquals(TYPE_RST_STREAM,rstStream.type);
assertEquals(CANCEL,rstStream.errorCode);
}