@Test public void onlyOneLiteralHeadersFrame() throws IOException {
assertFalse(outFinished);
assertTrue(inFinished);
assertEquals(expectedStreamId,streamId);
assertEquals(-1,associatedStreamId);
assertEquals(-1,priority);
assertEquals(sentHeaders,headerBlock);
assertEquals(HeadersMode.HTTP_20_HEADERS,headersMode);
}