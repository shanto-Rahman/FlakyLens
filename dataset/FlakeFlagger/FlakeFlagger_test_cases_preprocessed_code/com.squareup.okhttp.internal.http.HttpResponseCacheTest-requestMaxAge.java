@Test public void requestMaxAge() throws IOException {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertEquals("B",readAscii(connection));
}