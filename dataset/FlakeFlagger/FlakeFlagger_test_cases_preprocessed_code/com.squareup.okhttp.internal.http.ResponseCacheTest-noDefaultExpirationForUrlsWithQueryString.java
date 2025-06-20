@Test public void noDefaultExpirationForUrlsWithQueryString() throws Exception {
assertEquals("A",readAscii(openConnection(url)));
assertEquals("B",readAscii(openConnection(url)));
}