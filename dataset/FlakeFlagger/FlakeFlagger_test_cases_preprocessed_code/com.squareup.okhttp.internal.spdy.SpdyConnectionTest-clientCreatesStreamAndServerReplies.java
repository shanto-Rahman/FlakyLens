@Test public void clientCreatesStreamAndServerReplies() throws Exception {
assertEquals(headerEntries("a","android"),stream.getResponseHeaders());
assertEquals(0,connection.openStreamCount());
assertEquals(TYPE_HEADERS,synStream.type);
assertEquals(HeadersMode.SPDY_SYN_STREAM,synStream.headersMode);
assertFalse(synStream.inFinished);
assertFalse(synStream.outFinished);
assertEquals(1,synStream.streamId);
assertEquals(0,synStream.associatedStreamId);
assertEquals(headerEntries("b","banana"),synStream.headerBlock);
assertTrue(Arrays.equals("c3po".getBytes("UTF-8"),requestData.data));
}