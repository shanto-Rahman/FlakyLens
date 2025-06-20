@Test public void varyMatchesRemovedRequestHeaderField() throws Exception {
assertEquals("A",readAscii(fooConnection));
assertEquals("B",readAscii(openConnection(server.getUrl("/"))));
}