@Test public void requestMaxStaleNotHonoredWithMustRevalidate() throws IOException {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertEquals("B",readAscii(connection));
}