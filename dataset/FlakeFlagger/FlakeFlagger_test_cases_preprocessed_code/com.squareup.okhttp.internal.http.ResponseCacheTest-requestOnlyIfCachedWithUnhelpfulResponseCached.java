@Test public void requestOnlyIfCachedWithUnhelpfulResponseCached() throws IOException {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
}