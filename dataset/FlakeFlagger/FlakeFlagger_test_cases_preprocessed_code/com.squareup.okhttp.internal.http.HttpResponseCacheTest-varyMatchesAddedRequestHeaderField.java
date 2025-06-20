@Test public void varyMatchesAddedRequestHeaderField() throws Exception {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertEquals("B",readAscii(fooConnection));
}