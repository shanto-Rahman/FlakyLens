@Test public void headersBeforeReply() throws Exception {
fail();
assertEquals("stream was reset: PROTOCOL_ERROR",expected.getMessage());
assertEquals(TYPE_HEADERS,synStream.type);
assertEquals(HeadersMode.SPDY_SYN_STREAM,synStream.headersMode);
assertEquals(TYPE_PING,ping.type);
assertEquals(TYPE_RST_STREAM,rstStream.type);
assertEquals(PROTOCOL_ERROR,rstStream.errorCode);
}