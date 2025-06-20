@Test public void varyMatchesAbsentRequestHeaderField() throws Exception {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
}