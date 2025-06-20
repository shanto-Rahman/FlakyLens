@Test public void serverCreatesStreamAndClientReplies() throws Exception {
receiveCount.incrementAndGet();
assertEquals(pushHeaders,stream.getRequestHeaders());
assertEquals(null,stream.getErrorCode());
assertEquals(5,stream.getPriority());
assertEquals(TYPE_HEADERS,reply.type);
assertEquals(HeadersMode.SPDY_REPLY,reply.headersMode);
assertFalse(reply.inFinished);
assertEquals(2,reply.streamId);
assertEquals(headerEntries("b","banana"),reply.headerBlock);
assertEquals(1,receiveCount.get());
}