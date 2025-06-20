@Test public void getHeadersDeletesCached100LevelWarnings() throws Exception {
assertEquals("A",readAscii(connection1));
assertEquals("199 test danger",connection1.getHeaderField("Warning"));
assertEquals("A",readAscii(connection2));
assertEquals(null,connection2.getHeaderField("Warning"));
}