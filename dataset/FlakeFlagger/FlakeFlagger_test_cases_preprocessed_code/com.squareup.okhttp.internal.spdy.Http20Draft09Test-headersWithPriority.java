@Test public void headersWithPriority() throws IOException {
assertFalse(outFinished);
assertFalse(inFinished);
assertEquals(expectedStreamId,streamId);
assertEquals(-1,associatedStreamId);
assertEquals(0,priority);
assertEquals(sentHeaders,nameValueBlock);
assertEquals(HeadersMode.HTTP_20_HEADERS,headersMode);
}