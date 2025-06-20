@Test public void requestOnlyIfCachedWithConditionalResponseCached() throws IOException {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
}