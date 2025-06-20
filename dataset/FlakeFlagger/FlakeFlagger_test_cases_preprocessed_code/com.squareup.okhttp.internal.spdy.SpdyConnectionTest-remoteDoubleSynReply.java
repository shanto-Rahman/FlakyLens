@Test public void remoteDoubleSynReply() throws Exception {
assertEquals(headerEntries("a","android"),stream.getResponseHeaders());
fail();
assertEquals("stream was reset: STREAM_IN_USE",expected.getMessage());
assertEquals(TYPE_HEADERS,synStream.type);
assertEquals(HeadersMode.SPDY_SYN_STREAM,synStream.headersMode);
assertEquals(TYPE_PING,ping.type);
assertEquals(TYPE_RST_STREAM,rstStream.type);
assertEquals(1,rstStream.streamId);
assertEquals(STREAM_IN_USE,rstStream.errorCode);
}