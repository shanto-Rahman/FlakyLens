@Test public void headersOnlyStreamIsClosedAfterReplyHeaders() throws Exception {
assertEquals(1,connection.openStreamCount());
assertEquals(headerEntries("b","banana"),stream.getResponseHeaders());
assertEquals(0,connection.openStreamCount());
}