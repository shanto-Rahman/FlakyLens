@Test public void useCachesFalseDoesNotWriteToCache() throws Exception {
assertEquals("A",readAscii(connection));
assertEquals("B",readAscii(openConnection(server.getUrl("/"))));
}