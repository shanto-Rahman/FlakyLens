@Test public void close() throws Exception {
assertEquals(1,connection.openStreamCount());
assertEquals(0,connection.openStreamCount());
fail();
assertEquals("shutdown",expected.getMessage());
fail();
assertEquals("stream was reset: CANCEL",expected.getMessage());
fail();
assertEquals("stream was reset: CANCEL",expected.getMessage());
assertEquals(TYPE_HEADERS,synStream.type);
assertEquals(HeadersMode.SPDY_SYN_STREAM,synStream.headersMode);
assertEquals(TYPE_GOAWAY,goaway.type);
assertEquals(TYPE_RST_STREAM,rstStream.type);
assertEquals(1,rstStream.streamId);
}