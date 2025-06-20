@Test public void requestCacheControlNoCache() throws Exception {
assertEquals("A",readAscii(openConnection(url)));
assertEquals("B",readAscii(connection));
}