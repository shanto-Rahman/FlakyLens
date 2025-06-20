@Test public void serverClosesClientInputStream() throws Exception {
assertEquals(0,connection.openStreamCount());
assertEquals(TYPE_HEADERS,synStream.type);
assertEquals(HeadersMode.SPDY_SYN_STREAM,synStream.headersMode);
assertTrue(synStream.inFinished);
assertFalse(synStream.outFinished);
}