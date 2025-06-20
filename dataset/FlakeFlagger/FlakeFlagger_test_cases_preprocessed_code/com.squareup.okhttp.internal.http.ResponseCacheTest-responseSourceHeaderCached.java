@Test public void responseSourceHeaderCached() throws IOException {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertEquals("A",readAscii(connection));
assertEquals(ResponseSource.CACHE + " 200",source);
}