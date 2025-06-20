@Test public void varyMatchesUnchangedRequestHeaderField() throws Exception {
assertEquals("A",readAscii(connection1));
assertEquals("A",readAscii(connection2));
}