@Test public void requestMinFresh() throws IOException {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertEquals("B",readAscii(connection));
}