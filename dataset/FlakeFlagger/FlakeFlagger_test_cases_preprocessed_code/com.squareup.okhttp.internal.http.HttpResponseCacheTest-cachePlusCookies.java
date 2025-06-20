@Test public void cachePlusCookies() throws Exception {
assertEquals("A",readAscii(openConnection(url)));
assertEquals("A",readAscii(openConnection(url)));
}