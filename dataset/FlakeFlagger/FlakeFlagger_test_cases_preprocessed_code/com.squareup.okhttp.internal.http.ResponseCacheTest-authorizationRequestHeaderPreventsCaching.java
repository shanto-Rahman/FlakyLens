@Test public void authorizationRequestHeaderPreventsCaching() throws Exception {
assertEquals("A",readAscii(connection));
assertEquals("B",readAscii(openConnection(url)));
}