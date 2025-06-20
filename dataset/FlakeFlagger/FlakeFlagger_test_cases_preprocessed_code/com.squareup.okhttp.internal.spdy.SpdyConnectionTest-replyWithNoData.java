@Test public void replyWithNoData() throws Exception {
receiveCount.incrementAndGet();
assertEquals(TYPE_HEADERS,reply.type);
assertTrue(reply.inFinished);
assertEquals(headerEntries("b","banana"),reply.headerBlock);
assertEquals(1,receiveCount.get());
assertEquals(HeadersMode.SPDY_REPLY,reply.headersMode);
}