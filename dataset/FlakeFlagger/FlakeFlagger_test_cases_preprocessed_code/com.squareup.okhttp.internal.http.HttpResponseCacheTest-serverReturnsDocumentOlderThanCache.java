@Test public void serverReturnsDocumentOlderThanCache() throws Exception {
assertEquals("A",readAscii(openConnection(url)));
assertEquals("A",readAscii(openConnection(url)));
}