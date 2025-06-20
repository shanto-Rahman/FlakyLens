@Test public void varyAsterisk() throws Exception {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertEquals("B",readAscii(openConnection(server.getUrl("/"))));
}