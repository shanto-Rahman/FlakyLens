@Test public void useCachesFalseDoesNotReadFromCache() throws Exception {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertEquals("B",readAscii(connection));
}