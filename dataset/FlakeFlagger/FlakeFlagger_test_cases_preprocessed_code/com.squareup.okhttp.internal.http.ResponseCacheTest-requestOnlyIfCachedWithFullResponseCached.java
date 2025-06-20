@Test public void requestOnlyIfCachedWithFullResponseCached() throws IOException {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertEquals("A",readAscii(connection));
}