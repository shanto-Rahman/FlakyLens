@Test public void getHeadersRetainsCached200LevelWarnings() throws Exception {
assertEquals("A",readAscii(connection1));
assertEquals("299 test danger",connection1.getHeaderField("Warning"));
assertEquals("A",readAscii(connection2));
assertEquals("299 test danger",connection2.getHeaderField("Warning"));
}