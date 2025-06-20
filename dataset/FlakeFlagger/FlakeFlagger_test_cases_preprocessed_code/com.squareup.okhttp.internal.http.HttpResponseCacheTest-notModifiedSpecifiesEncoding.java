@Test public void notModifiedSpecifiesEncoding() throws Exception {
assertEquals("ABCABCABC",readAscii(openConnection(server.getUrl("/"))));
assertEquals("ABCABCABC",readAscii(openConnection(server.getUrl("/"))));
assertEquals("DEFDEFDEF",readAscii(openConnection(server.getUrl("/"))));
}