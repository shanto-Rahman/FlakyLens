@Test public void headers() throws Exception {
assertEquals(headerEntries("a","android","c","c3po"),stream.getResponseHeaders());
assertEquals(TYPE_HEADERS,synStream.type);
assertEquals(HeadersMode.SPDY_SYN_STREAM,synStream.headersMode);
assertEquals(TYPE_PING,ping.type);
}