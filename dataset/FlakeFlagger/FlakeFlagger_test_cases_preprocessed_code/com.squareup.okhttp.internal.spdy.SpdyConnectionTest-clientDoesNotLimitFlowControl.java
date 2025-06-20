@Test public void clientDoesNotLimitFlowControl() throws Exception {
assertEquals(headerEntries("b","banana"),stream.getResponseHeaders());
assertEquals(TYPE_HEADERS,synStream.type);
assertEquals(HeadersMode.SPDY_SYN_STREAM,synStream.headersMode);
assertEquals(TYPE_PING,ping.type);
assertEquals(2,ping.payload1);
}