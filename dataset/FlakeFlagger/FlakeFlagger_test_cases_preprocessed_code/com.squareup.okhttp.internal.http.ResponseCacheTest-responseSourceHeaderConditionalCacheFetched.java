@Test public void responseSourceHeaderConditionalCacheFetched() throws IOException {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertEquals("B",readAscii(connection));
assertEquals(ResponseSource.CONDITIONAL_CACHE + " 200",source);
}