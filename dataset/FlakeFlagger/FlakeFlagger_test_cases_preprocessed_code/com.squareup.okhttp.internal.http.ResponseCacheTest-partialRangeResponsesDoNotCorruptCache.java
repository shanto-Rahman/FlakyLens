@Test public void partialRangeResponsesDoNotCorruptCache() throws Exception {
assertEquals("AA",readAscii(range));
assertEquals("BB",readAscii(openConnection(url)));
}