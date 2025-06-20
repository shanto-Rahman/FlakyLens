@Test public void responseSourceHeaderConditionalCacheNotFetched() throws IOException {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertEquals("A",readAscii(connection));
assertEquals(ResponseSource.CONDITIONAL_CACHE + " 304",source);
}