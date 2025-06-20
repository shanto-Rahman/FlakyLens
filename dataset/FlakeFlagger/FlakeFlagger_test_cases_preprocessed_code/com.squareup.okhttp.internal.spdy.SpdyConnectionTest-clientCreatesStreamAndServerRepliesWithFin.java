@Test public void clientCreatesStreamAndServerRepliesWithFin() throws Exception {
assertEquals(1,connection.openStreamCount());
assertEquals(0,connection.openStreamCount());
assertEquals(TYPE_HEADERS,synStream.type);
assertEquals(HeadersMode.SPDY_SYN_STREAM,synStream.headersMode);
assertEquals(TYPE_PING,ping.type);
}