@Test public void remoteDoubleSynStream() throws Exception {
receiveCount.incrementAndGet();
assertEquals(headerEntries("a","android"),stream.getRequestHeaders());
assertEquals(null,stream.getErrorCode());
assertEquals(TYPE_HEADERS,reply.type);
assertEquals(HeadersMode.SPDY_REPLY,reply.headersMode);
assertEquals(TYPE_RST_STREAM,rstStream.type);
assertEquals(2,rstStream.streamId);
assertEquals(PROTOCOL_ERROR,rstStream.errorCode);
assertEquals(1,receiveCount.intValue());
}