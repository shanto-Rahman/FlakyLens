@Test public void remoteSendsDataAfterInFinished() throws Exception {
assertEquals(headerEntries("a","android"),stream.getResponseHeaders());
assertEquals(TYPE_HEADERS,synStream.type);
assertEquals(HeadersMode.SPDY_SYN_STREAM,synStream.headersMode);
assertEquals(TYPE_PING,ping.type);
assertEquals(2,ping.payload1);
}