@Test public void remoteSendsRefusedStreamBeforeReplyHeaders() throws Exception {
fail();
assertEquals("stream was reset: REFUSED_STREAM",expected.getMessage());
assertEquals(0,connection.openStreamCount());
assertEquals(TYPE_HEADERS,synStream.type);
assertEquals(HeadersMode.SPDY_SYN_STREAM,synStream.headersMode);
assertEquals(TYPE_PING,ping.type);
assertEquals(2,ping.payload1);
}