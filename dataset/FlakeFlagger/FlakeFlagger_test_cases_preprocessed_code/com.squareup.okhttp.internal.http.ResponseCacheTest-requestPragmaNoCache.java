@Test public void requestPragmaNoCache() throws Exception {
assertEquals("A",readAscii(openConnection(url)));
assertEquals("B",readAscii(connection));
}