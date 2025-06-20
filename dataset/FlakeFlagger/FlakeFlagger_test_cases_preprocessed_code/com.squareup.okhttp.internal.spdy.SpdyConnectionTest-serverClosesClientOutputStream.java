@Test public void serverClosesClientOutputStream() throws Exception {
fail();
assertEquals("stream was reset: CANCEL",expected.getMessage());
fail();
assertEquals(0,connection.openStreamCount());
assertEquals(TYPE_HEADERS,synStream.type);
assertEquals(HeadersMode.SPDY_SYN_STREAM,synStream.headersMode);
assertFalse(synStream.inFinished);
assertFalse(synStream.outFinished);
assertEquals(TYPE_PING,ping.type);
assertEquals(1,ping.payload1);
}