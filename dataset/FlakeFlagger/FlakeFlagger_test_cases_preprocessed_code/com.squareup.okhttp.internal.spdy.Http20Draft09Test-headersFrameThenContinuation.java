/** 
 * Headers are compressed, then framed. 
 */
@Test public void headersFrameThenContinuation() throws IOException {
assertFalse(outFinished);
assertFalse(inFinished);
assertEquals(expectedStreamId,streamId);
assertEquals(-1,associatedStreamId);
assertEquals(-1,priority);
assertEquals(headerEntries("foo","barrr","baz","qux"),headerBlock);
assertEquals(HeadersMode.HTTP_20_HEADERS,headersMode);
}