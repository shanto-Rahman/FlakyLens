@Test public void contentLocationDoesNotPopulateCache() throws Exception {
assertEquals("A",readAscii(openConnection(server.getUrl("/foo"))));
assertEquals("B",readAscii(openConnection(server.getUrl("/bar"))));
}